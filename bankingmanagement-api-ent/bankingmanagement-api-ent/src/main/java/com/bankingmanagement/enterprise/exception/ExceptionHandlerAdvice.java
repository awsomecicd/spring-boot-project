package com.bankingmanagement.enterprise.exception;


import com.sun.jdi.request.ExceptionRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BankDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleBankDetailsNotFoundException(HttpServletRequest request, BankDetailsNotFoundException exception){
        log.info("Inside the bank details not found exception handler");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Exception not found exception ", exception);
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(HttpServletRequest request, BankDetailsNotFoundException exception){
        log.info("Inside the exception handler details not found ");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Error Exception not found exception", exception);
        return response;
    }
}
