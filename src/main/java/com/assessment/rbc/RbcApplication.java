package com.assessment.rbc;

import com.assessment.rbc.models.StockEntity;
import com.assessment.rbc.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RbcApplication {
	public static void main(String[] args) {
		SpringApplication.run(RbcApplication.class, args);
	}
}

@Component
class ReadDataFile implements CommandLineRunner {
	private final StockRepository stockRepository;

	public ReadDataFile(StockRepository stockRepository){
		this.stockRepository = stockRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		try{
			InputStream inputStream = getClass().getResourceAsStream("/dow_jones_index.data");
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line = reader.readLine();
			List<StockEntity> stockEntityList = new ArrayList<>();
			while(line != null){
				System.out.println(line);
				String[] str = line.split(",");
				stockEntityList.add(dataMapper(str));
				line = reader.readLine();
			}
			System.out.println(stockEntityList);
			stockRepository.saveAll(stockEntityList);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private StockEntity dataMapper(String[] strArr){
		StockEntity stockEntity = new StockEntity();
		stockEntity.setQuarter(strArr[0]);
		stockEntity.setStock(strArr[1]);
		stockEntity.setDate(strArr[2]);
		stockEntity.setOpen(strArr[3]);
		stockEntity.setHigh(strArr[4]);
		stockEntity.setLow(strArr[5]);
		stockEntity.setClose(strArr[6]);
		stockEntity.setVolume(strArr[7]);
		stockEntity.setPercentChangePrice(strArr[8]);
		stockEntity.setPercentChangeVolumeOverLastWk(strArr[9]);
		stockEntity.setPreviousWeeksVolume(strArr[10]);
		stockEntity.setNextWeeksOpen(strArr[11]);
		stockEntity.setNextWeeksClose(strArr[12]);
		stockEntity.setPercentChangeNextWeeksPrice(strArr[13]);
		stockEntity.setDaysToNextDividend(strArr[14]);
		stockEntity.setPercentReturnNextDividend(strArr[15]);
		return stockEntity;
	}
}