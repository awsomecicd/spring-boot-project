package com.bankingmanagement.service;

import com.bankingmanagement.entities.Bank;
import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BankTO;
import org.springframework.boot.diagnostics.analyzer.BeanNotOfRequiredTypeFailureAnalyzer;

import java.util.List;



public interface BankService {
    List<BankTO> findAll() throws BankDetailsNotFoundException;
    BankTO findById(String id) throws BankDetailsNotFoundException;
    BankTO save(BankRequest bankRequest) throws BankDetailsNotFoundException;
    boolean deleteById(String id) throws BankDetailsNotFoundException;
    BankTO updateById(String id, BankRequest bankRequest) throws BankDetailsNotFoundException;


}
