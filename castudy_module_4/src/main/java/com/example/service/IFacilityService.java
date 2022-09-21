package com.example.service;


import com.example.module.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface IFacilityService {


    Page<Facility> findAll(Pageable pageable);
}
