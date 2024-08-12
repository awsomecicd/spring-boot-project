package com.bankingmanagement.controller;


import com.bankingmanagement.entities.Branch;
import com.bankingmanagement.exception.AccountDetailsNotFoundException;
import com.bankingmanagement.exception.BranchDetailsNotFoundException;
import com.bankingmanagement.model.AccountRequest;
import com.bankingmanagement.model.AccountTO;
import com.bankingmanagement.model.BranchRequest;
import com.bankingmanagement.model.BranchTO;
import com.bankingmanagement.service.BranchService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/branches")
public class BranchController {
    @Autowired
    private BranchService branchService;

    // http://localhost:8087/api/vi/branches
    @GetMapping
    public ResponseEntity<List<BranchTO>> findAll() throws BranchDetailsNotFoundException {
        log.info("Inside findAll account controller");
        List<BranchTO> branchTOList = null;
        try{
            branchTOList = branchService.findAll();
        }catch (BranchDetailsNotFoundException exception){
            log.info("BankNot found!!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception ex1){
            log.info("Exception while fetching account details");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("End of account controller find all!");
        return new ResponseEntity<>(branchTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchTO> findById(String id) throws BranchDetailsNotFoundException{
        log.info("Inside account controller findById id:{}",id);
        BranchTO branchTO = branchService.findById(id);
        log.info("End of account getMapping findById");
        return new ResponseEntity<>(branchTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BranchTO> saveAccountDetails(@RequestBody @Valid BranchRequest branchRequest) throws BranchDetailsNotFoundException{
        log.info("Inside account Post mapping");
        BranchTO branchTO = branchService.save(branchRequest);
        return new ResponseEntity<>(branchTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(String id) throws BranchDetailsNotFoundException {
        log.info("Inside account delete mapper deleteById id:{}", id);
        boolean branchBool = branchService.deleteById(id);
        return new ResponseEntity<>(branchBool, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchTO> updateById(String id, @RequestBody @Valid BranchRequest branchRequest) throws BranchDetailsNotFoundException{
        log.info("Inside account put mapping updateById id:{}", id);
        BranchTO branchTO = branchService.updateById(id,branchRequest);
        log.info("End of account put mapping updateById");
        return new ResponseEntity<>(branchTO, HttpStatus.OK);
    }
}
