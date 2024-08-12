package com.bankingmanagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
public class LoanTO {

    private long loanId;
    private String loanType;
    private long loanAmount;
}
