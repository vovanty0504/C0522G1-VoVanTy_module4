package com.example.repository;

import com.example.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPhoneRepository extends JpaRepository<SmartPhone, Long> {

}
