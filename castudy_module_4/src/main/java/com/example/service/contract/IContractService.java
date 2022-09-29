package com.example.service.contract;

import com.example.module.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

}
