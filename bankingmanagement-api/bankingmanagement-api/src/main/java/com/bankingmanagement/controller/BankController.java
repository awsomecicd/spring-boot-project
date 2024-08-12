package com.bankingmanagement.controller;


import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BankTO;
import com.bankingmanagement.service.BankService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    // http://localhost:port/api/v1/banks GET
    @GetMapping
    public ResponseEntity<List<BankTO>> findAll() {
        log.info("Inside the BankController.findAll");
        List<BankTO> bankTOList = null;
        try {
            bankTOList = bankService.findAll();
        }catch (BankDetailsNotFoundException exception){
            log.error("Bank details not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception exception1) {
            log.error("Exceiption while fetching bank deatils");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("End of bank controller findall");
        return new ResponseEntity<>(bankTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankTO> findById(@RequestParam("id") String id) throws BankDetailsNotFoundException {
        log.info("Inside the BankController.findById, id:{}", id);
        BankTO bankTO = bankService.findById(id);
        log.info("End of BankController.findById");
        return new ResponseEntity<>(bankTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BankTO> saveBankDetails(@RequestBody @Valid BankRequest bankRequest) throws BankDetailsNotFoundException{
        BankTO bankTO = bankService.save(bankRequest);
        return new ResponseEntity<>(bankTO, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBankDetailsById(@RequestParam("id") String id) throws BankDetailsNotFoundException{
        log.info("Inside the BankController.deleteBankDetailsById, id:{}", id);
        boolean bankBool = bankService.deleteById(id);
        log.info("End of BankController.deleteBankDetailsById");
        return new ResponseEntity<>(bankBool, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankTO> update(@RequestParam("id") String id, @RequestBody @Valid BankRequest bankRequest) throws BankDetailsNotFoundException{
        log.info("Inside the BankController.update, by Id:{}, bankRequest:{}", id, bankRequest);
        BankTO bankTO = bankService.updateById(id, bankRequest);
        return new ResponseEntity<>(bankTO, HttpStatus.OK);
    }


}
