package com.example.service;


import com.example.module.EducationDegree;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEducationDegreeService {

    List<EducationDegree> findAll();

}
