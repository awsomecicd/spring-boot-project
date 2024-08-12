package com.bankingmanagement.repository;

import com.bankingmanagement.entities.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRepository extends MongoRepository <Loan, String> {

}
