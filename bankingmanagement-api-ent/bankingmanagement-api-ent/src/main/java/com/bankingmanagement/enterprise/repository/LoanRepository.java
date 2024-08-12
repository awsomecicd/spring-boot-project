package com.bankingmanagement.enterprise.repository;

import com.bankingmanagement.enterprise.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
