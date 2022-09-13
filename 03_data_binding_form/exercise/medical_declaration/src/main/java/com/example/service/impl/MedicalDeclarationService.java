package com.example.service.impl;

import com.example.model.MedicalDeclaration;
import com.example.repository.IMedicalDeclarationRepository;
import com.example.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {

    @Autowired
    private IMedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarationRepository.findAll();
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.save(medicalDeclaration);
    }

    @Override
    public List<String> travelInformation() {
        return medicalDeclarationRepository.travelInformation();
    }

    @Override
    public List<String> country() {
        return medicalDeclarationRepository.country();
    }

    @Override
    public List<String> gender() {
        return medicalDeclarationRepository.gender();
    }




}
