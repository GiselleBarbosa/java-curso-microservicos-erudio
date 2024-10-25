package com.barbosa.challenges.mathChallenge;

import com.barbosa.challenges.mathChallenge.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{number1}/{number2}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "number1") String number1, @PathVariable(value = "number2") String number2)
            throws Exception {

        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(number1) + convertToDouble(number2);
    }

    @RequestMapping(value = "/subtraction/{number1}/{number2}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "number1") String number1, @PathVariable(value = "number2") String number2)
            throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(number1) - convertToDouble(number2);
    }

    @RequestMapping(value = "/multiplication/{number1}/{number2}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "number1") String number1, @PathVariable(value = "number2") String number2)
            throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(number1) * convertToDouble(number2);
    }

    @RequestMapping(value = "/division/{number1}/{number2}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "number1") String number1, @PathVariable(value = "number2") String number2)
            throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(number1) / convertToDouble(number2);
    }

    @RequestMapping(value = "/average/{number1}/{number2}", method = RequestMethod.GET)
    public Double average(@PathVariable(value = "number1") String number1, @PathVariable(value = "number2") String number2)
            throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(number1) + convertToDouble(number2)) / 2;
    }

    @RequestMapping(value = "/squareroot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number)
            throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(number));
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }

    private static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}