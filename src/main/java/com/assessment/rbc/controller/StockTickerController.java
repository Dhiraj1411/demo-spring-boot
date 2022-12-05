package com.assessment.rbc.controller;

import com.assessment.rbc.dto.Stock;
import com.assessment.rbc.service.StockService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class StockTickerController {
    public final StockService stockService;

    @Autowired
    public StockTickerController(StockService stockService){
        this.stockService = stockService;
    }

    @ApiOperation(value = "Fetch the Stock based on stock names", response = Stock.class)
    @GetMapping("/stock/{param}")
    public ResponseEntity<List<Stock>> getStockes(@PathVariable String param) throws Exception {
        String body = "This is the response: "+param;
        List<Stock> stockList = stockService.getStocks(param);
        Map<String, String> map = new HashMap<>();
        ResponseEntity<List<Stock>> response = new ResponseEntity<List<Stock>>(stockList, null, HttpStatus.OK);
        return response;
    }

    @ApiOperation(value = "Bulk update", response = String.class)
    @PostMapping("/bulksave")
    public ResponseEntity<String> bulkUpload(@RequestBody List<Stock> stocks){
        String respBody = stockService.bulkUpload(stocks);
        Map<String, String> map = new HashMap<>();
        ResponseEntity<String> response = new ResponseEntity<String>(respBody, null, HttpStatus.OK);
        return response;
    }

    /* this method ideally is not required can be taken care with the bulkupload */
    @ApiOperation(value = "Save a Stock", response = String.class)
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Stock stock){
        String body = "This is the response: "+stock;
        String respBody = stockService.saveStock(stock);
        Map<String, String> map = new HashMap<>();
        ResponseEntity<String> response = new ResponseEntity<String>(respBody, null, HttpStatus.OK);
        return response;
    }

}
