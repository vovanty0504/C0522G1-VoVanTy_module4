package com.example.repository.impl;

import com.example.model.MedicalDeclaration;
import com.example.repository.IMedicalDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {
    private static List<MedicalDeclaration> medicalDeclarationList = new ArrayList<>();

    static {
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarationList;
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationList.add(medicalDeclaration);
    }

    @Override
    public List<String> travelInformation() {
        List<String> travelInformationList = new ArrayList<>();
        travelInformationList.add("may bay");
        travelInformationList.add("tau thuyen");
        travelInformationList.add("o to");
        travelInformationList.add("khac");
        return travelInformationList;
    }

    @Override
    public List<String> country() {
        List<String> country = new ArrayList<>();
        country.add("viet nam");
        country.add("thai lan");
        country.add("han quoc ");
        country.add("nhat ban");
        return country;
    }

    @Override
    public List<String> gender() {
        List<String> gender = new ArrayList<>();
        gender.add("nam");
        gender.add("nu");
        gender.add("LGBT");
        return gender;
    }


}
