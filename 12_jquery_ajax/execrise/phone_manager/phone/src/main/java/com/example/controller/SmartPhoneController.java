package com.example.controller;


import com.example.model.SmartPhone;
import com.example.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
@CrossOrigin("*")
public class SmartPhoneController {
    @Autowired
    private IPhoneService phoneService;


    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartphone) {
        return new ResponseEntity<>(phoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone> findById(@PathVariable Long id) {
        if (!phoneService.findById(id).isPresent()){
            return new ResponseEntity<>(phoneService.findById(id).get(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phoneService.findById(id).get(), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<SmartPhone>> getAllSmartphonePage() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = phoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SmartPhone> updateBlog(@PathVariable Long id,
                                                 @RequestBody SmartPhone smartphone) {
        SmartPhone currentSmartphone = phoneService.findById(id).get();
        if (currentSmartphone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentSmartphone.setModel(smartphone.getModel());
        currentSmartphone.setPrice(smartphone.getPrice());
        currentSmartphone.setProducer(smartphone.getProducer());

        phoneService.save(currentSmartphone);
        return new ResponseEntity<>(currentSmartphone, HttpStatus.OK);
    }
}
