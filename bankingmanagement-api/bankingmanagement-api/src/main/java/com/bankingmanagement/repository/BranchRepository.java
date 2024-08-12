package com.bankingmanagement.repository;

import com.bankingmanagement.entities.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BranchRepository extends MongoRepository <Branch, String> {
}
