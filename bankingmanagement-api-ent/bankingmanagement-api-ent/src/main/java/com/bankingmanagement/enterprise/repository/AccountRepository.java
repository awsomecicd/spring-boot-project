package com.bankingmanagement.enterprise.repository;

import com.bankingmanagement.enterprise.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
