package com.bankingmanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter

public class CustomerRequest {

    private int custId;
    @NotNull
    private String name;
    @NotNull
    private long phone;
    @NotNull
    private String address;

}
