package com.example.service;

import com.example.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {

    List<MedicalDeclaration> findAll();

    void save(MedicalDeclaration medicalDeclaration);

    List<String> travelInformation();

    List<String> country();

    List<String> gender();

    String[] departureDay();

    String[] departureMonth();

    String[] departureYear();

    String[] endDay();

    String[] endMonth();

    String[] endYear();

    String[] dayOfBirth();
}
