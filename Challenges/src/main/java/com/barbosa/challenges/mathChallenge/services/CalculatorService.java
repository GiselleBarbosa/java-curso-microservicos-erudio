package com.barbosa.challenges.mathChallenge.services;

import com.barbosa.challenges.mathChallenge.exceptions.UnsupportedMathOperationException;
import com.barbosa.challenges.mathChallenge.utils.Converter;
import org.springframework.stereotype.Service;

import static com.barbosa.challenges.mathChallenge.utils.Converter.isNumeric;

@Service
public class CalculatorService {

    Converter converter = new Converter();

    public Double sum(String number1, String number2) {

        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return converter.convertToDouble(number1) + converter.convertToDouble(number2);
    }

    public Double subtraction(String number1, String number2) throws Exception {

        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return converter.convertToDouble(number1) - converter.convertToDouble(number2);
    }

    public Double multiplication(String number1, String number2) throws Exception {

        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return converter.convertToDouble(number1) * converter.convertToDouble(number2);
    }

    public Double division(String number1, String number2) throws Exception {

        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return converter.convertToDouble(number1) / converter.convertToDouble(number2);
    }

    public Double average(String number1, String number2)
            throws Exception {

        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (converter.convertToDouble(number1) + converter.convertToDouble(number2)) / 2;
    }

    public Double squareRoot(String number)
            throws Exception {

        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(converter.convertToDouble(number));
    }
}