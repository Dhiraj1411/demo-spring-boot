package com.assessment.rbc.service;

import com.assessment.rbc.dto.Stock;

import java.util.List;

public interface StockService {
    public String saveStock(Stock stock);
    public String bulkUpload(List<Stock> stockList);
    public List<Stock> getStocks(String id) throws Exception;
}
