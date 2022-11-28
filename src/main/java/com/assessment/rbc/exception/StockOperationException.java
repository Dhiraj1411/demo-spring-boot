package com.assessment.rbc.exception;

public class StockOperationException extends RuntimeException{
    public StockOperationException(String message){
        super(message);
    }
}
