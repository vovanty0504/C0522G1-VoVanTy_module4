package com.example.service;

import com.example.module.Position;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPositionService {

    List<Position> findAll();

}
