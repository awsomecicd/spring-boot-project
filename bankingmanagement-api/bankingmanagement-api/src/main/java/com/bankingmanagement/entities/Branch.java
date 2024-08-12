package com.bankingmanagement.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "branch_col")
public class Branch {
    @Id
    private String id;

    @Field(name ="Branch_ID")
    private int branchId;
    @Field(name = "Branch_Name")
    private String branchName;
    @Field(name = "Branch_Address")
    private String branchAddress;
}
