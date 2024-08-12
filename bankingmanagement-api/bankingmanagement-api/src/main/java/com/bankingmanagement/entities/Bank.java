package com.bankingmanagement.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Setter
@Getter
@Document(collection = "bank_Col")
public class Bank {
    @Id
    private String id;
    @Field(name ="Bank_Code")
    private int bankCode;
    @Field(name = "Bank_Name")
    private String bankName;
    @Field(name = "Bank_Address")
    private String bankAddress;

    public Bank() {}
    public Bank(int bankCode){
        this.bankCode = bankCode;

    }

    @Override
    public String toString(){
        return String.format("Bank[id=%s, bankCode=%s,bankName=%s,bankAddress=%s]",
                id,bankCode,bankName,bankAddress);
    }
}
