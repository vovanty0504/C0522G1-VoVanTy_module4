package com.codegym.cinema.service.impl;

import com.codegym.cinema.model.Cinema;
import com.codegym.cinema.repository.ICinemaRepository;
import com.codegym.cinema.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService implements ICinemaService {

    @Autowired
    private ICinemaRepository iCinemaRepository;

    @Override
    public List<Cinema> findAll() {
        return iCinemaRepository.findAll();
    }

    @Override
    public void delete(Cinema cinema) {
        iCinemaRepository.delete(cinema);
    }

    @Override
    public Optional<Cinema> findById(Integer id) {
        return iCinemaRepository.findById(id);
    }

    @Override
    public void save(Cinema cinema) {
        iCinemaRepository.save(cinema);
    }
}
