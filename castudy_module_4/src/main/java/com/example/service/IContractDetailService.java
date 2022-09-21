package com.example.service;


import com.example.module.ContractDetail;
import com.example.repository.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
public interface IContractDetailService {



    List<ContractDetail> findAll();
}
