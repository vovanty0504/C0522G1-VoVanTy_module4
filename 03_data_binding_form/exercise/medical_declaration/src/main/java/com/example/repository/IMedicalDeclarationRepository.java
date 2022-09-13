package com.example.repository;

import com.example.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {

    List<MedicalDeclaration> findAll();

     void save(MedicalDeclaration medicalDeclaration);

    List<String> travelInformation();
}
