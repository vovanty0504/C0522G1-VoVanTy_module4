package com.example.service.impl;

import com.example.model.Email;
import com.example.repository.IEmailRepository;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public void save(Email email) {
        emailRepository.save(email);
    }

    @Override
    public Email findById(int id) {
        return emailRepository.findById(id);
    }

    @Override
    public void update(Email email) {
        emailRepository.update(email);
    }

    @Override
    public List<String> languages() {
        return emailRepository.languages();
    }

    @Override
    public List<Integer> pageSize() {
        return emailRepository.pageSize();
    }
}
