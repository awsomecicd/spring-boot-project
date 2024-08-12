package com.bankingmanagement.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CustomerTO {

    private int custId;
    private String name;
    private long phone;
    private String address;
}
