package com.assessment.demo.service;

import com.assessment.demo.dto.Stock;

import java.util.List;

public interface StockService {
    public String saveStock(Stock stock);
    public String bulkUpload(List<Stock> stockList);
    public List<Stock> getStocks(String id) throws Exception;
}
