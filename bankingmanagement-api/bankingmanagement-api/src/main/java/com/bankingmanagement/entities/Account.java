package com.bankingmanagement.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Setter
@Getter
@Document(collection = "accout_col")
public class Account {
    @Id
    private String id;
    @Field(name = "account_number")
    private long accountNumber;
    @Field(name = "account_type")
    private String accountType;
    @Field(name = "account_balance")
    private String accountBalance;
}
