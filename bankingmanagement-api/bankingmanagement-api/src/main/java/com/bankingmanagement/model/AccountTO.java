package com.bankingmanagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
public class AccountTO {

    private long accountNumber;
    private String accountType;
    private String accountBalance;

}
