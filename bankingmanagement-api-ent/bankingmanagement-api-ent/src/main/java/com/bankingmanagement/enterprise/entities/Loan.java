package com.bankingmanagement.enterprise.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "T_Loan")
@Entity
@Getter
@Setter
public class Loan {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loadIdSequence")
    @SequenceGenerator(name="loadIdSequence",sequenceName="loan_id_sequence", allocationSize=1)
    @Id
    @Column(name="Loan_ID")
    private long loanId;
    @Column(name="Loan_Type")
    private String loanType;
    @Column(name="Loan_Amount")
    private long loanAmount;
//    @Column(name = "Branch_ID")
//    private long branchId;
//    @Column(name = "Cust_ID")
//    private long custId;

    @ManyToOne
    @JoinColumn(name = "Branch_ID")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "Cust_ID")
    private Customer customer;



}
