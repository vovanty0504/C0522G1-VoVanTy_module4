package com.codegym.service.impl;

import com.codegym.service.ICurrencyConversionService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService {

    @Override
    public double calculate( double money) {
        return money * 23000;
    }
}
