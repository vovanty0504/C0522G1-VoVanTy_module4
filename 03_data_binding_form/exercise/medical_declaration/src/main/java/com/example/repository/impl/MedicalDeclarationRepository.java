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

    @Override
    public String[] departureDay() {
        return new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    }

    @Override
    public String[] departureMonth() {
        return new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    }

    @Override
    public String[] departureYear() {
        return new String[]{"2019","2020","2021","2022","2023"};
    }

    @Override
    public String[] endDay() {
        return new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    }

    @Override
    public String[] endMonth() {
        return new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    }

    @Override
    public String[] endYear() {
        return new String[]{"2019","2020","2021","2022","2023","2024"};
    }

    @Override
    public String[] dayOfBirth() {
        return new String[]{"2010","2002","2003","2004","2005"};
    }


}
