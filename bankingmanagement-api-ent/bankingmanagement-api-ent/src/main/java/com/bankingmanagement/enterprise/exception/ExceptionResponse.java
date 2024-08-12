package com.bankingmanagement.enterprise.exception;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
}
