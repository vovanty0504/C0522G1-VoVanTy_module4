package com.example.repository.facility;

import com.example.module.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from facility where facility_name like %:nameSearch% and is_delete = false", nativeQuery = true)
    Page<Facility> searchFacility(@RequestParam("nameSearch") String nameSearch, Pageable pageable);

    @Modifying
    @Query(value = "update facility set is_delete = true where facility_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}

