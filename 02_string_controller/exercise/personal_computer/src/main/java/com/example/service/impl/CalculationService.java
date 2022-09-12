package com.example.service.impl;

import com.example.service.ICalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculationService implements ICalculationService {

    @Override
    public String result(String number1, String number2, String calculation) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            double result = 0;
            switch (calculation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        return "cannot be division by 0";
                    } else {
                        result = num1 / num2;
                    }
                    break;
            }
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "not allowed to input text";
        }
    }
}
