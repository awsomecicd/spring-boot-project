package com.bankingmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class AccountRequest {

    private long accountNumber;
    @NotNull
    private String accountType;
    @NotNull
    private String accountBalance;

}
