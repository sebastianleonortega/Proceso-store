package com.procesos.store.exception;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
