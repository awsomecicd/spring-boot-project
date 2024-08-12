package com.bankingmanagement.enterprise.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_Branch")
@Getter
@Setter
public class Branch {


    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branchIdSequence")
    @SequenceGenerator(name="branchIdSequence",sequenceName="branch_id_sequence", allocationSize=1)
    @Id
    @Column(name ="Branch_ID")
    private int branchId;
    @Column(name = "Branch_Name")
    private String branchName;
    @Column(name = "Branch_Address")
    private String branchAddress;

    @ManyToOne
    @JoinColumn(name = "Bank_Code")
    private Bank bank;





}
