package com.apirest.backprojeto.services.exception;



public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUD = 1L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }   
} 