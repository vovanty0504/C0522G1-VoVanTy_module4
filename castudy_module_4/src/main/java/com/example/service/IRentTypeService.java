package com.example.service;


import com.example.module.RentType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRentTypeService {

    List<RentType> findAll();

}
