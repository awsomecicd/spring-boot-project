package com.bankingmanagement.exception;

public class LoanDetailsNotFoundException extends Exception{
    public LoanDetailsNotFoundException(){
        super();
    }
    public LoanDetailsNotFoundException(String msg){
        super(msg);
    }
}
