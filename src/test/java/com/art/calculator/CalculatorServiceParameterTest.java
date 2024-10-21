package com.art.calculator;


import com.art.calculator.service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.art.calculator.CalculatorServiceTestConstants.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceParameterTest {

    private final CalculatorService out = new CalculatorService();

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectResultOfSummation(double num1, double num2) {
        assertEquals(num1 + num2, out.plus(num1, num2));
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectResultOfSubstation(double num1, double num2) {
        assertEquals(num1 - num2, out.minus(num1, num2));
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectResultOfMultiply(double num1, double num2) {
        assertEquals(num1 * num2, out.multiply(num1, num2));
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectResultOfDivide(double num1, double num2) {
        if (num2 == 0) {
            assertThrows(ZeroDivideException.class, () -> out.divide(num1, num2));
        } else {
            assertEquals(num1 / num2, out.divide(num1, num2));
        }
    }

    public static Stream<Arguments> provideArgumentsForCalculatorTests() {
        return Stream.of(
                Arguments.of(ZERO, ONE),
                Arguments.of(ONE, TWO),
                Arguments.of(TWO, THREE),
                Arguments.of(THREE, ZERO),
                Arguments.of(TWO, THREE)
        );
    }
}
