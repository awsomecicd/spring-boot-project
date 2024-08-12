package com.bankingmanagement.enterprise.repository;

import com.bankingmanagement.enterprise.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}
