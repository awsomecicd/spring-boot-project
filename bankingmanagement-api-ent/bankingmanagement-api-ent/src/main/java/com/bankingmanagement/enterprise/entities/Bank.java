package com.bankingmanagement.enterprise.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "T_Bank")
@Setter
@Getter
public class Bank {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bankCodeSequence" )
    @SequenceGenerator(name="bankCodeSequence",sequenceName="bank_code_sequence", allocationSize=1)
    @Id
    @Column(name ="Bank_Code")
    private int bankCode;
    @Column(name = "Bank_Name")
    private String bankName;
    @Column(name = "Bank_Address")
    private String bankAddress;

    @OneToMany(mappedBy = "bank")
    private Set<Branch> branches;


}
