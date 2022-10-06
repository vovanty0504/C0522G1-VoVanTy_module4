package com.example.service.contract;

import com.example.dto.IContractDto;
import com.example.model.contract.Contract;
import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IContractService {

    Page<IContractDto> findAll(Pageable pageable);


//    List<IContractDto> findAll();

    void save(Contract contract);

}
