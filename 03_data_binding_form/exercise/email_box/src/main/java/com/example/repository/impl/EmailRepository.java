package com.example.repository.impl;

import com.example.model.Email;
import com.example.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {

    private static List<Email> emailList = new ArrayList<>();

    static {
        emailList.add(new Email(1, "English", 5, true, "abc"));
        emailList.add(new Email(2, "Vietnamese", 10, false, "abc"));
        emailList.add(new Email(3, "Japanese", 15, false, "abc"));
        emailList.add(new Email(4, "Chinese", 20, true, "abc"));
    }


    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public void save(Email email) {
        emailList.add(email);
    }

    @Override
    public Email findById(int id) {
        for (Email e : emailList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void update(Email email) {
        for (int i = 0; i < emailList.size(); i++) {
            if (emailList.get(i).getId() == email.getId()) {
                emailList.set(i, email);
            }
        }
    }

    @Override
    public List<String> languages() {
        List<String> languagesList = new ArrayList<>();
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
        return languagesList;
    }

    @Override
    public List<Integer> pageSize() {
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(20);
        pageSize.add(40);
        pageSize.add(50);
        pageSize.add(80);
        pageSize.add(100);
        return pageSize;
    }


}
