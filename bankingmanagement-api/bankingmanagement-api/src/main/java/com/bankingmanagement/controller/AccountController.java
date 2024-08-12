package com.bankingmanagement.controller;


import com.bankingmanagement.exception.AccountDetailsNotFoundException;
import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.AccountRequest;
import com.bankingmanagement.model.AccountTO;
import com.bankingmanagement.service.AccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // http://localhost:8087/api/vi/accounts
    @GetMapping
    public ResponseEntity<List<AccountTO>> findAll() throws AccountDetailsNotFoundException{
        log.info("Inside findAll account controller");
        List<AccountTO> accountTOList = null;
        try{
            accountTOList = accountService.findAll();
        }catch (AccountDetailsNotFoundException exception){
            log.info("BankNot found!!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception ex1){
            log.info("Exception while fetching account details");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("End of account controller find all!");
        return new ResponseEntity<>(accountTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountTO> findById(String id) throws AccountDetailsNotFoundException{
        log.info("Inside account controller findById id:{}",id);
        AccountTO accountTO = accountService.findById(id);
        log.info("End of account getMapping findById");
        return new ResponseEntity<>(accountTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountTO> saveAccountDetails(@RequestBody @Valid AccountRequest accountRequest) throws AccountDetailsNotFoundException{
        log.info("Inside account Post mapping");
        AccountTO accountTO = accountService.save(accountRequest);
        return new ResponseEntity<>(accountTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(String id) throws AccountDetailsNotFoundException {
        log.info("Inside account delete mapper deleteById id:{}", id);
        boolean accountBool = accountService.deleteById(id);
        return new ResponseEntity<>(accountBool, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountTO> updateById(String id, @RequestBody @Valid AccountRequest accountRequest) throws AccountDetailsNotFoundException{
        log.info("Inside account put mapping updateById id:{}", id);
        AccountTO accountTO = accountService.updateById(id,accountRequest);
        log.info("End of account put mapping updateById");
        return new ResponseEntity<>(accountTO, HttpStatus.OK);
    }



}

