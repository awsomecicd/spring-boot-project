package com.bankingmanagement.enterprise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankRequest {
    private int bankCode;
    @NotNull
    private String bankName;
    @NotNull
    private String bankAddress;
}
