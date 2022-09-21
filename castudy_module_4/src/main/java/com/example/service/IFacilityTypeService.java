package com.example.service;


import com.example.module.FacilityType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IFacilityTypeService {


    List<FacilityType> findAll();
}
