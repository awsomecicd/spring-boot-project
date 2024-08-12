package com.bankingmanagement.service;


import com.bankingmanagement.entities.Account;
import com.bankingmanagement.entities.Branch;
import com.bankingmanagement.exception.AccountDetailsNotFoundException;
import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.exception.BranchDetailsNotFoundException;
import com.bankingmanagement.model.AccountRequest;
import com.bankingmanagement.model.AccountTO;
import com.bankingmanagement.model.BranchRequest;
import com.bankingmanagement.model.BranchTO;
import com.bankingmanagement.repository.AccountRepository;
import com.bankingmanagement.repository.BranchRepository;
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
public class BranchServiceImp implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<BranchTO> findAll() throws BranchDetailsNotFoundException {
        log.info("Inside AccountServiceImp.findAll()");
        List<Branch> branchList = branchRepository.findAll();
        if(CollectionUtils.isEmpty(branchList)){
            log.info("No account details found");
            throw new BranchDetailsNotFoundException("NO Account Details found ");
        }

        List<BranchTO> branchTOS = branchList.stream().map(branch -> {
            BranchTO branchTO = new BranchTO();
            branchTO.setBranchId(branch.getBranchId());
            branchTO.setBranchName(branch.getBranchName());
            branchTO.setBranchAddress(branch.getBranchAddress());
            return branchTO;

        }).collect(Collectors.toList());
        log.info("End of find all for branch class");
        return branchTOS;



    }

    @Override
    public BranchTO findById(String id) throws BranchDetailsNotFoundException {
        log.info("Inside Account service findById");
        Optional<Branch> branchOptional = branchRepository.findById(id);
        if(branchOptional.isEmpty()){
            log.error("Account details not found");
            throw new BranchDetailsNotFoundException("Account details not found!!");
        }
        Branch branch = branchOptional.get();
        log.info("Account details:{}", branch);
        BranchTO branchTO = new BranchTO();
        branchTO.setBranchId(branch.getBranchId());
        branchTO.setBranchName(branch.getBranchName());
        branchTO.setBranchAddress(branch.getBranchAddress());
        log.info("End of account.findById method!!");
        return branchTO;
    }

    @Override
    public BranchTO save(BranchRequest branchRequest) throws BranchDetailsNotFoundException{
        log.info("Inside AccountServiceImp.save");
        Branch branch = new Branch();
        branch.setBranchId(branchRequest.getBranchId());
        branch.setBranchName(branchRequest.getBranchName());
        branch.setBranchAddress(branchRequest.getBranchAddress());
        Branch saveBranch = branchRepository.save(branch);


        if(Objects.isNull(saveBranch)){
            log.error("Error while saving the data to repository!");
            throw new BranchDetailsNotFoundException("Posting requestBody to repository failed!");
        }
        BranchTO branchTO = new BranchTO();
        branchTO.setBranchId(saveBranch.getBranchId());
        branchTO.setBranchName(saveBranch.getBranchName());
        branchTO.setBranchAddress(saveBranch.getBranchAddress());
        log.info("End of accountServiceImp.save");
        return branchTO;
    }

    @Override
    public boolean deleteById(String id) throws BranchDetailsNotFoundException{
        log.info("Inside accountServiceImp.deleteById id:{}", id);
        Optional<Branch> branchOptional = branchRepository.findById(id);
        if(branchOptional.isEmpty()){
            log.error("Account details not found");
            throw new BranchDetailsNotFoundException("Account details not found!");
        }

        log.info("End of accountServiceImp.deleteById");
        branchRepository.deleteById(id);
        return true;

    }

    @Override
    public BranchTO updateById(String id, BranchRequest branchRequest) throws BranchDetailsNotFoundException{
        log.info("Inside of accountServiceImp.updateById Id:{}", id);
        Optional<Branch> branchOptional = branchRepository.findById(id);
        if(branchOptional.isEmpty()){
            log.error("Branch details not found");
            throw new BranchDetailsNotFoundException("Branch details not found");
        }
        Branch branchToUpdate = branchOptional.get();
        if(branchRequest.getBranchId() != branchToUpdate.getBranchId()){
            log.error("Branch type mis-match");
            throw new BranchDetailsNotFoundException("Branch type mis match");

        }

        branchToUpdate.setBranchId(branchRequest.getBranchId());
        branchToUpdate.setBranchName(branchRequest.getBranchName());
        branchToUpdate.setBranchAddress(branchRequest.getBranchAddress());
        Branch saveBranch = branchRepository.save(branchToUpdate);

        BranchTO branchTO = new BranchTO();
        branchTO.setBranchId(saveBranch.getBranchId());
        branchTO.setBranchName(saveBranch.getBranchName());
        branchTO.setBranchAddress(saveBranch.getBranchAddress());
        return branchTO;

    }
}
