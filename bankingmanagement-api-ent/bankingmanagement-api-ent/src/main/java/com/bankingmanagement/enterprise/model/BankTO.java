package com.bankingmanagement.enterprise.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BankTO {
    private int bankCode;
    private String bankName;
    private String bankAddress;
}
