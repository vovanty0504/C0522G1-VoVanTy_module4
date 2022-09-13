package com.example.service;

import com.example.model.Email;

import java.util.List;

public interface IEmailService {

    List<Email> findAll();

    void save(Email email);

    Email findById(int id);

    void update(Email email);

    List<String> languages();

    List<Integer> pageSize();
}
