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
        medicalDeclarationList.add(new MedicalDeclaration("Van Ty", "05/04/2001", "Nam", "Việt nam", 241399524, "tàu bay", "81B1-28117", 10, "01-01-2020", "02/01/2080", "none"));
        medicalDeclarationList.add(new MedicalDeclaration("Trung Thuyen", "01/01/1996", "Nam", "Việt nam", 241399524, "Xe ô tô", "75H-2121", 5, "01-01-2020", "03/01/2080", "none"));
        medicalDeclarationList.add(new MedicalDeclaration("Dai Loi", "01/01/1995", "Nam", "Việt nam", 241399524, "Xe ô tô", "43H-10257", 4, "01-01-2020", "04/01/2080", "none"));
        medicalDeclarationList.add(new MedicalDeclaration("Thuy Tien", "20/03/2000", "Nam", "Việt nam", 241399524, "tàu thuyền", "92H-10157", 8, "01-01-2020", "04/01/2080", "none"));
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


}
