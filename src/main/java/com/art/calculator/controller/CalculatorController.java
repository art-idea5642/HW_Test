package com.art.calculator.controller;

import com.art.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plusNumbers(@RequestParam double num1, @RequestParam double num2){
        double result = calculatorService.plus(num1, num2);
        return String.format("%.0f + %.0f = %.0f", num1, num2, result);
    }

    @GetMapping("/minus")
    public String minusNumbers(@RequestParam double num1, @RequestParam double num2){
        double result = calculatorService.minus(num1, num2);
        return String.format("%.0f - %.0f = %.0f", num1, num2, result);
    }
    @GetMapping("/multiply")
    public String multiplyNumbers(@RequestParam double num1, @RequestParam double num2){
        double result = calculatorService.multiply(num1, num2);
        return String.format("%.0f * %.0f = %.0f", num1, num2, result);
    }

    @GetMapping("/divide")
    public String divideNumbers(@RequestParam double num1, @RequestParam double num2){
        double result = calculatorService.divide(num1, num2);
        return String.format("%.0f / %.0f = %.0f", num1, num2, result);
    }


}
