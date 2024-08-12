package com.bankingmanagement.enterprise.service;

import com.bankingmanagement.enterprise.exception.BankDetailsNotFoundException;
import com.bankingmanagement.enterprise.model.BankRequest;
import com.bankingmanagement.enterprise.model.BankTO;

import java.util.List;

public interface BankService {

    List<BankTO> findAll() throws BankDetailsNotFoundException;
    BankTO findById(int id) throws BankDetailsNotFoundException;
    BankTO save(BankRequest bankRequest) throws BankDetailsNotFoundException;
    boolean deleteById(int id) throws BankDetailsNotFoundException;
    BankTO updateById(int id, BankRequest bankRequest) throws BankDetailsNotFoundException;
}
