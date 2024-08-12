package com.bankingmanagement.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@Document(collection = "loan_col")
public class Loan {

    @Id
    private String id;

    @Field(name="Loan_ID")
    private long loanId;
    @Field(name="Loan_Type")
    private String loanType;
    @Field(name="Loan_Amount")
    private long loanAmount;
}
