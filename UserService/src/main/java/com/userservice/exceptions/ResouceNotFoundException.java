package com.userservice.exceptions;

public class ResouceNotFoundException extends RuntimeException{

    public ResouceNotFoundException(){
        super("Resouce Not Found");
    }

    public ResouceNotFoundException(String message){
        super(message);
    }

}
