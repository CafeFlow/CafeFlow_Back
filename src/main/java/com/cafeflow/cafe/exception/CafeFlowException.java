package com.cafeflow.cafe.exception;

import lombok.Getter;

@Getter
public abstract class CafeFlowException extends RuntimeException{
    public CafeFlowException(String message){
        super(message);
    }
    public abstract int getStatusCode();
}
