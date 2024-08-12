package com.bankingmanagement.exception;

public class AccountDetailsNotFoundException extends Exception {
    public AccountDetailsNotFoundException(){
        super();
    }
    public AccountDetailsNotFoundException(String msg){
        super(msg);
    }
}
