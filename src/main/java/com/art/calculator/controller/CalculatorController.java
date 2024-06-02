package com.art.calculator.controller;

import com.art.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping
    public String sum(int num1, int num2) {

        return num1 + " + " + num2 + " = " + calculatorService.sum(num1, num2);
    }

    @GetMapping
    public String minus(int num1, int num2) {
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }

    @GetMapping
    public String multiply(int num1, int num2) {
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }

    @GetMapping
    public String divide(int num1, int num2) {
        if (num2 == 0) {
            return "На ноль делить нельзя";
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }
}
