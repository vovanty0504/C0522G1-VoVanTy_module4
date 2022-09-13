package com.example.service;

import com.example.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {

    List<MedicalDeclaration> findAll();

    void save(MedicalDeclaration medicalDeclaration);

    List<String> travelInformation();

    List<String> country();

    List<String> gender();

}
