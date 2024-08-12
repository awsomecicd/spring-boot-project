package com.bankingmanagement.enterprise.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_Account")
@Getter
@Setter
public class Account {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountIdSequence")
    @SequenceGenerator(name="accountIdSequence",sequenceName="account_id_sequence", allocationSize=1)
    @Id
    @Column(name ="Account_Number")
    private int accountNumber;
    @Column(name = "Account_Type")
    private String accountType;
    @Column(name = "Account_Balance")
    private String accountBalance;


    @ManyToOne
    @JoinColumn(name = "Branch_ID")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "Cust_ID")
    private Customer customer;

}
