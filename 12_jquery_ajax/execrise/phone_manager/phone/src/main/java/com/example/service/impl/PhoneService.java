package com.example.service.impl;

import com.example.model.SmartPhone;
import com.example.repository.IPhoneRepository;
import com.example.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return phoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return phoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        phoneRepository.deleteById(id);
    }


    @Override
    public void update(SmartPhone smartPhone) {
        phoneRepository.save(smartPhone);
    }
}
