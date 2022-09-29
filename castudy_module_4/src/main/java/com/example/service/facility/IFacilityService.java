package com.example.service.facility;


import com.example.module.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IFacilityService {


    Page<Facility> findAll(Pageable pageable);
}
