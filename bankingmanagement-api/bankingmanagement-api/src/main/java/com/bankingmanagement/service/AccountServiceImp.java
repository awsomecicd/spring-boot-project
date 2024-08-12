package com.bankingmanagement.service;


import com.bankingmanagement.entities.Account;
import com.bankingmanagement.exception.AccountDetailsNotFoundException;
import com.bankingmanagement.model.AccountRequest;
import com.bankingmanagement.model.AccountTO;
import com.bankingmanagement.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountTO> findAll() throws AccountDetailsNotFoundException {
        log.info("Inside AccountServiceImp.findAll()");
        List<Account> accountList = accountRepository.findAll();
        if(CollectionUtils.isEmpty(accountList)){
            log.info("No account details found");
            throw new AccountDetailsNotFoundException("NO Account Details found ");
        }

        List<AccountTO> accountTOS = accountList.stream().map(account -> {
            AccountTO accountTO = new AccountTO();
            accountTO.setAccountNumber(account.getAccountNumber());
            accountTO.setAccountType(account.getAccountType());
            accountTO.setAccountBalance(account.getAccountBalance());
            return accountTO;
        }).collect(Collectors.toList());
        log.info("End of AccountServiceImp.findAll()");
        return accountTOS;

    }

    @Override
    public AccountTO findById(String id) throws AccountDetailsNotFoundException{
        log.info("Inside Account service findById");
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            log.error("Account details not found");
            throw new AccountDetailsNotFoundException("Account details not found!!");
        }
        Account account = accountOptional.get();
        log.info("Account details:{}", account);
        AccountTO accountTO = new AccountTO();
        accountTO.setAccountNumber(account.getAccountNumber());
        accountTO.setAccountType(account.getAccountType());
        accountTO.setAccountBalance(account.getAccountBalance());
        log.info("End of account.findById method!!");
        return accountTO;
    }

    @Override
    public AccountTO save(AccountRequest accountRequest) throws AccountDetailsNotFoundException{
        log.info("Inside AccountServiceImp.save");
        Account account = new Account();
        account.setAccountNumber(accountRequest.getAccountNumber());
        account.setAccountType(accountRequest.getAccountType());
        account.setAccountBalance(accountRequest.getAccountBalance());
        Account saveAccount = accountRepository.save(account);


        if(Objects.isNull(saveAccount)){
            log.error("Error while saving the data to repository!");
            throw new AccountDetailsNotFoundException("Posting requestBody to repository failed!");
        }
        AccountTO accountTO = new AccountTO();
        accountTO.setAccountNumber(saveAccount.getAccountNumber());
        accountTO.setAccountType(saveAccount.getAccountType());
        accountTO.setAccountBalance(saveAccount.getAccountBalance());
        log.info("End of accountServiceImp.save");
        return accountTO;
    }

    @Override
    public boolean deleteById(String id) throws AccountDetailsNotFoundException{
        log.info("Inside accountServiceImp.deleteById id:{}", id);
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            log.error("Account details not found");
            throw new AccountDetailsNotFoundException("Account details not found!");
        }

        log.info("End of accountServiceImp.deleteById");
        accountRepository.deleteById(id);
        return true;

    }

    @Override
    public AccountTO updateById(String id, AccountRequest accountRequest) throws AccountDetailsNotFoundException{
        log.info("Inside of accountServiceImp.updateById Id:{}", id);
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            log.error("Account details not found");
            throw new AccountDetailsNotFoundException("Account details not found");
        }
        Account accountToUpdate = accountOptional.get();
        if(accountRequest.getAccountType() != accountToUpdate.getAccountType()){
            log.error("Account type mis-match");
            throw new AccountDetailsNotFoundException("Account type mis match");

        }

        accountToUpdate.setAccountNumber(accountRequest.getAccountNumber());
        accountToUpdate.setAccountType(accountRequest.getAccountType());
        accountToUpdate.setAccountBalance(accountRequest.getAccountBalance());
        Account saveAccount = accountRepository.save(accountToUpdate);

        AccountTO accountTO = new AccountTO();
        accountTO.setAccountNumber(saveAccount.getAccountNumber());
        accountTO.setAccountType(saveAccount.getAccountType());
        accountTO.setAccountBalance(saveAccount.getAccountBalance());
        return accountTO;

    }
}
