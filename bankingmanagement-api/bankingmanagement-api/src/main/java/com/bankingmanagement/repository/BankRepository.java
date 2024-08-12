package com.bankingmanagement.repository;

import com.bankingmanagement.entities.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BankRepository extends MongoRepository <Bank, String> {
    public Bank findByBankCode(int bankCode);

}
