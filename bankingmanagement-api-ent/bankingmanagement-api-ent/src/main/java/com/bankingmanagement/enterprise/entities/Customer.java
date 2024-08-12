package com.bankingmanagement.enterprise.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@Table(name="T_Customer")
public class Customer {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerIdSequence")
    @SequenceGenerator(name="customerIdSequence",sequenceName="customer_id_sequence", allocationSize=1)
    @Id
    @Column(name="Cust_ID")
    private int id;

    @Column(name="Cust_Name")
    private String name;

    @Column(name="Cust_Phone")
    private long phone;

    @Column(name = "Cust_Address")
    private String address;

    @OneToMany(mappedBy = "customer")
    private Set<Account> accountSet;
    @OneToMany(mappedBy = "customer")
    private Set<Loan> loanSet;



}
