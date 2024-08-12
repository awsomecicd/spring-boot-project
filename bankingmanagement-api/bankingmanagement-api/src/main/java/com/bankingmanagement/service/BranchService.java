package com.bankingmanagement.service;


import com.bankingmanagement.exception.BranchDetailsNotFoundException;
import com.bankingmanagement.model.BranchRequest;
import com.bankingmanagement.model.BranchTO;

import java.util.List;

public interface BranchService {
    List<BranchTO> findAll() throws BranchDetailsNotFoundException;
    BranchTO findById(String id) throws BranchDetailsNotFoundException;
    BranchTO save(BranchRequest branchRequest) throws BranchDetailsNotFoundException;
    boolean deleteById(String id) throws BranchDetailsNotFoundException;
    BranchTO updateById(String id, BranchRequest branchRequest) throws BranchDetailsNotFoundException;
}
