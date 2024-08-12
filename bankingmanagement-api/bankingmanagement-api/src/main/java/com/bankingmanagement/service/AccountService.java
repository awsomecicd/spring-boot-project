package com.bankingmanagement.service;

import com.bankingmanagement.exception.AccountDetailsNotFoundException;
import com.bankingmanagement.model.AccountRequest;
import com.bankingmanagement.model.AccountTO;


import java.util.List;


public interface AccountService {
    List<AccountTO> findAll() throws AccountDetailsNotFoundException;
    AccountTO findById(String id) throws AccountDetailsNotFoundException;
    AccountTO save(AccountRequest accountRequest) throws AccountDetailsNotFoundException;
    boolean deleteById(String id) throws AccountDetailsNotFoundException;
    AccountTO updateById(String id, AccountRequest accountRequest) throws AccountDetailsNotFoundException;

}
