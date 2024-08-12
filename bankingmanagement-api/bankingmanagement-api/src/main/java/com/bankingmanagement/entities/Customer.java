package com.bankingmanagement.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@Document(collection = "customer_col")
public class Customer {
    @Id
    private String id;

    @Field(name="Cust_ID")
    private int custId;

    @Field(name="Cust_Name")
    private String name;

    @Field(name="Cust_Phone")
    private long phone;

    @Field(name = "Cust_Address")
    private String address;
}
