package com.bankingmanagement.enterprise.service;


import com.bankingmanagement.enterprise.entities.Bank;
import com.bankingmanagement.enterprise.exception.BankDetailsNotFoundException;
import com.bankingmanagement.enterprise.model.BankRequest;
import com.bankingmanagement.enterprise.model.BankTO;
import com.bankingmanagement.enterprise.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class BankServiceImp implements BankService{
    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<BankTO> findAll() throws BankDetailsNotFoundException {
        log.info("Inside find all");
        List<Bank> bankList = bankRepository.findAll();
        if(CollectionUtils.isEmpty(bankList)){
            log.error("Bank details not found");
            throw new BankDetailsNotFoundException("BankDetails Notfound");
        }

        List<BankTO> bankTOS = bankList.stream().map(bank -> {
            BankTO bankTO = new BankTO();
            bankTO.setBankCode(bank.getBankCode());
            bankTO.setBankName(bank.getBankName());
            bankTO.setBankAddress(bank.getBankAddress());
            return bankTO;
        }).collect(Collectors.toList());
        log.info("End of BANK imp");
        return bankTOS;
    }

    @Override
    public BankTO findById(int id) throws BankDetailsNotFoundException {
        log.info("inside the BankServiceImpl.findById, id:{}", id);
        Optional<Bank> bankOptional = bankRepository.findById(id);
        if(bankOptional.isEmpty()) {
            log.error("Bank details not found");
            throw new BankDetailsNotFoundException("BankDetails not found");

        }
        Bank bank = bankOptional.get();
        log.info("Bank Details bank: {}", bank);
        BankTO bankTO = new BankTO();
        bankTO.setBankCode(bank.getBankCode());
        bankTO.setBankName(bank.getBankName());
        bankTO.setBankAddress(bank.getBankAddress());
        log.info("End of Bank serviceImp.findById");
        return bankTO;
    }

    @Override
    public BankTO save(BankRequest bankRequest) throws BankDetailsNotFoundException {
        log.info(" Inside the bankController.save bankRequest:{}",bankRequest);

        Bank bank = new Bank();
        bank.setBankCode(bankRequest.getBankCode());
        bank.setBankName(bankRequest.getBankName());
        bank.setBankAddress(bankRequest.getBankAddress());
        Bank saveBank = bankRepository.save(bank);

        if(Objects.isNull(saveBank)){
            log.error("Bank details not saved !");
            throw new BankDetailsNotFoundException("Bank details not saved");

        }
        log.info("Bank details bank:{}", saveBank);
        BankTO bankTO = new BankTO();
        bankTO.setBankCode(saveBank.getBankCode());
        bankTO.setBankName(saveBank.getBankName());
        bankTO.setBankAddress(saveBank.getBankAddress());
        log.info("End of BankServiceImp.save");
        return bankTO;
    }

    @Override
    public boolean deleteById(int id) throws BankDetailsNotFoundException {
        log.info("Inside delete method");
        Optional<Bank> bankOptional = bankRepository.findById(id);
        if(bankOptional.isEmpty()){
            log.error("Bank details not found");
            throw new BankDetailsNotFoundException("Bank details not found");
        }
        log.info("Bank details Bank:{}", bankOptional);
        bankRepository.deleteById(id);
        return true;
    }

    @Override
    public BankTO updateById(int id, BankRequest bankRequest) throws BankDetailsNotFoundException {
        log.info("Inside the updateById");
        Optional<Bank> bankOptional = bankRepository.findById(id);
        if (!bankOptional.isPresent()) {
            log.error("Update cancelled due to entity not found");
            throw new BankDetailsNotFoundException("Cancelled due to entity not found");

        }

        Bank bankToUpdate = bankOptional.get();
        if(bankRequest.getBankCode() != bankToUpdate.getBankCode()){
            log.error("BankCode not matched");
            throw new BankDetailsNotFoundException("BankCode Not Matched!");
        }
        bankToUpdate.setBankCode(bankRequest.getBankCode());
        bankToUpdate.setBankName(bankRequest.getBankName());
        bankToUpdate.setBankAddress(bankRequest.getBankAddress());
        Bank updateBank = bankRepository.save(bankToUpdate);

        if(Objects.isNull(updateBank)){
            log.error("Bank details not updated");
            throw new BankDetailsNotFoundException("Bank details not updated");
        }
        log.info("Bank update details:{}", updateBank);


        BankTO bankTO = new BankTO();
        bankTO.setBankCode(updateBank.getBankCode());
        bankTO.setBankName(updateBank.getBankName());
        bankTO.setBankAddress(updateBank.getBankAddress());

        log.info("End of BankServiceImp.save");
        return bankTO;
    }


}
