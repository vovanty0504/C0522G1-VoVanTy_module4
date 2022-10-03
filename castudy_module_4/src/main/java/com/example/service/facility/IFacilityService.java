package com.example.service.facility;


import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IFacilityService {

    Page<Facility> searchFacility(String nameSearch, Pageable pageable);

    void save(Facility facility);

    Optional<Facility> findById(Integer id);

    void deleteLogical(Integer id);

    void update(Facility facility);

    List<Facility> findAll();
}
