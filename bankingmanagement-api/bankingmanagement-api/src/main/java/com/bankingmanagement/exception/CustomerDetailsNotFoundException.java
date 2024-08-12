package com.bankingmanagement.exception;

public class CustomerDetailsNotFoundException extends Exception{
    public CustomerDetailsNotFoundException(){
        super();
    }
    public CustomerDetailsNotFoundException(String msg){
        super(msg);
    }
}
