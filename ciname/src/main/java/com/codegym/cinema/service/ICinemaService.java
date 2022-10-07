package com.codegym.cinema.service;

import com.codegym.cinema.model.Cinema;

import java.util.List;
import java.util.Optional;

public interface ICinemaService {
    List<Cinema> findAll();

    void delete(Cinema cinema);

    Optional<Cinema> findById(Integer id);

    void  save(Cinema cinema);
}
