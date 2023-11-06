package com.cafeflow.cafe.exception;

public class ServerErrorException extends CafeFlowException{
    public ServerErrorException(String message){
        super(message);
    }
    @Override
    public int getStatusCode(){
        return 500;
    }
}
