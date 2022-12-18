package com.assessment.demo.exception;

public class StockOperationException extends RuntimeException{
    public StockOperationException(String message){
        super(message);
    }
}
