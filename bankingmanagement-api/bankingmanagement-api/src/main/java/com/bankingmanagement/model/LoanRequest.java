package com.bankingmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanRequest {

    private long loanId;
    @NotNull
    private String loanType;
    @NotNull
    private long loanAmount;
}
