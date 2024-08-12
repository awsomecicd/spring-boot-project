package com.bankingmanagement.exception;



public class BranchDetailsNotFoundException extends Exception{
    public BranchDetailsNotFoundException(){
        super();
    }
    public BranchDetailsNotFoundException(String msg){
        super(msg);
    }
}
