package com.cafeflow.cafe.exception;

public class NonExistentException extends CafeFlowException{
    public NonExistentException(String message){
        super(message);
    }
    @Override
    public int getStatusCode(){
        return 400;
    }
}
