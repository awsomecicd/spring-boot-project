package com.bankingmanagement.repository;

import com.bankingmanagement.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <Customer, String> {
}
