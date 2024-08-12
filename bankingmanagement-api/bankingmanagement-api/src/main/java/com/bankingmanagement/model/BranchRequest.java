package com.bankingmanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchRequest {

    private int branchId;
    @NotNull
    private String branchName;
    @NotNull
    private String branchAddress;
}
