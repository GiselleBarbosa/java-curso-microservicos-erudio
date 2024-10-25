package com.barbosa.challenges.mathChallenge;

import com.barbosa.challenges.mathChallenge.services.CalculatorService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    CalculatorService calculatorService = new CalculatorService();

    @RequestMapping(value = "/sum/{number1}/{number2}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
            throws Exception {
        return calculatorService.sum(number1, number2);
    }

    @RequestMapping(value = "/subtraction/{number1}/{number2}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
            throws Exception {
        return calculatorService.subtraction(number1, number2);
    }

    @RequestMapping(value = "/multiplication/{number1}/{number2}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
            throws Exception {
        return calculatorService.multiplication(number1, number2);
    }

    @RequestMapping(value = "/division/{number1}/{number2}", method = RequestMethod.GET)
    public Double division(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
            throws Exception {
        return calculatorService.division(number1, number2);
    }

    @RequestMapping(value = "/average/{number1}/{number2}", method = RequestMethod.GET)
    public Double average(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
            throws Exception {
        return calculatorService.average(number1, number2);
    }

    @RequestMapping(value = "/squareroot/{number}", method = RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value = "number") String number) throws Exception {
        return calculatorService.squareRoot(number);
    }
}