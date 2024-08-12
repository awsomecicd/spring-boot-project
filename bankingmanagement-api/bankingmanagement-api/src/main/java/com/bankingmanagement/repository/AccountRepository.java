package com.bankingmanagement.repository;

import com.bankingmanagement.entities.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository <Account, String> {
}
