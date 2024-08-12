package com.bankingmanagement.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BranchTO {

    private int branchId;
    private String branchName;
    private String branchAddress;
}
