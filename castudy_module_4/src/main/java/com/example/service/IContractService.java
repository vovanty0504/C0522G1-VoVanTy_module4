package com.example.service;

import com.example.module.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

}
