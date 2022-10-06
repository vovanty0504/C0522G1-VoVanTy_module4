package com.example.service.contract.impl;

import com.example.dto.IContractDto;
import com.example.model.contract.Contract;
import com.example.repository.contract.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;


    @Override
    public Page<IContractDto> findAll(Pageable pageable) {
        return contractRepository.findAllDto(pageable);
    }

//    public List<IContractDto> findAll( ) {
//        return contractRepository.findAllDto();
//    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
