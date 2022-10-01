package com.example.service.facility;


import com.example.module.customer.Customer;
import com.example.module.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IFacilityService {

    Page<Facility> searchFacility(String nameSearch, Pageable pageable);

    void save(Facility facility);

    Optional<Facility> findById(Integer id);

    void deleteLogical(Integer id);

    void update(Facility facility);
}
