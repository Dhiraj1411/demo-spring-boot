package com.assessment.rbc.service;

import com.assessment.rbc.dto.Stock;
import com.assessment.rbc.exception.StockOperationException;
import com.assessment.rbc.models.StockEntity;
import com.assessment.rbc.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    public final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public String saveStock(Stock stock) {
        String resp = null;
        try{
            resp = "Data successfully saved";
            stockRepository.save(stockDtoToEntityMapper(stock));
        }catch (Exception ex){
            resp = "Exception occurred while saving data";
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public String bulkUpload(List<Stock> stockList) {
        String resp = null;
        try{
            List<StockEntity> stockEntityList = new ArrayList<>();
            stockList.stream().forEach(stock -> {
                stockEntityList.add(stockDtoToEntityMapper(stock));
            });
            stockRepository.saveAll(stockEntityList);
            resp = "Data successfully saved";
        }catch (Exception ex){
            resp = "Exception occurred while saving bulk data";
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Stock> getStocks(String stock_param){
        List<Stock> stockList = new ArrayList<>();
        try{
            Optional<List<StockEntity>> optionalStockList = stockRepository.findByStock(stock_param);
            if(optionalStockList.isPresent()){
                for(StockEntity stockEntity  : optionalStockList.get()){
                    stockList.add(stockEntityToStockDtoMapper(stockEntity));
                }
            } else {
                throw new StockOperationException(stock_param +" doesn't exist");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return stockList;
    }

    private Stock stockEntityToStockDtoMapper(StockEntity stockEntity){
        Stock stockDto = new Stock();
        stockDto.setQuarter(stockEntity.getQuarter());
        stockDto.setStock(stockEntity.getStock());
        stockDto.setDate(stockEntity.getDate());
        stockDto.setHigh(stockEntity.getHigh());
        stockDto.setOpen(stockEntity.getOpen());
        stockDto.setClose(stockEntity.getClose());
        stockDto.setLow(stockEntity.getLow());
        stockDto.setVolume(stockEntity.getVolume());
        stockDto.setDaysToNextDividend(stockEntity.getDaysToNextDividend());
        stockDto.setNextWeeksClose(stockEntity.getNextWeeksClose());
        stockDto.setNextWeeksOpen(stockEntity.getNextWeeksOpen());
        stockDto.setPercentChangeNextWeeksPrice(stockEntity.getPercentChangeNextWeeksPrice());
        stockDto.setPercentChangeVolumeOverLastWk(stockEntity.getPercentChangeVolumeOverLastWk());
        stockDto.setPercentChangePrice(stockEntity.getPercentChangePrice());
        stockDto.setPercentReturnNextDividend(stockEntity.getPercentReturnNextDividend());
        return stockDto;
    }

    private StockEntity stockDtoToEntityMapper(Stock stockDto){
        StockEntity stockEntity = new StockEntity();
        stockEntity.setQuarter(stockDto.getQuarter());
        stockEntity.setStock(stockDto.getStock());
        stockEntity.setDate(stockDto.getDate());
        stockEntity.setHigh(stockDto.getHigh());
        stockEntity.setOpen(stockDto.getOpen());
        stockEntity.setClose(stockDto.getClose());
        stockEntity.setLow(stockDto.getLow());
        stockEntity.setVolume(stockDto.getVolume());
        stockEntity.setDaysToNextDividend(stockDto.getDaysToNextDividend());
        stockEntity.setNextWeeksClose(stockDto.getNextWeeksClose());
        stockEntity.setNextWeeksOpen(stockDto.getNextWeeksOpen());
        stockEntity.setPercentChangeNextWeeksPrice(stockDto.getPercentChangeNextWeeksPrice());
        stockEntity.setPercentChangeVolumeOverLastWk(stockDto.getPercentChangeVolumeOverLastWk());
        stockEntity.setPercentChangePrice(stockDto.getPercentChangePrice());
        stockEntity.setPercentReturnNextDividend(stockDto.getPercentReturnNextDividend());
        return stockEntity;
    }
}
