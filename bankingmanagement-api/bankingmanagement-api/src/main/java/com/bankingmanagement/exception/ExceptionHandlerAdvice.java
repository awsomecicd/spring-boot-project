package com.bankingmanagement.exception;

import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BankDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleBankDetailsNotFoundException(HttpServletRequest request, BankDetailsNotFoundException exception) {
        log.info("Inside the bank details not found exception handler");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Bank details not found exception", exception);
        return response;
    }

    @ExceptionHandler(AccountDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleAccountDetailsNotFoundException(HttpServletRequest request, BankDetailsNotFoundException exception) {
        log.info("Inside the Account details not found exception handler");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Account details not found exception", exception);
        return response;
    }

    @ExceptionHandler(BranchDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleBranchDetailsNotFoundException(HttpServletRequest request, BankDetailsNotFoundException exception) {
        log.info("Inside the Branch details not found exception handler");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Branch details not found exception", exception);
        return response;
    }

    @ExceptionHandler(CustomerDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleCustomerDetailsNotFoundException(HttpServletRequest request, BankDetailsNotFoundException exception) {
        log.info("Inside the Customer details not found exception handler");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Customer details not found exception", exception);
        return response;
    }

    @ExceptionHandler(LoanDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleLoanDetailsNotFoundException(HttpServletRequest request, BankDetailsNotFoundException exception) {
        log.info("Inside the Loan details not found exception handler");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Loan details not found exception", exception);
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(HttpServletRequest request, BankDetailsNotFoundException exception) {
        log.info("Inside the Exception handler not found exception handler");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Exception not found exception", exception);
        return response;
    }


}
