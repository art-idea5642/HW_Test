package com.art.calculator;

import com.art.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;

import static com.art.calculator.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceTest {

    private final CalculatorService out = new CalculatorService();

    @Test
    public void shouldReturn1WhenSum0And1 () { assertEquals (ONE, out.plus(ZERO, ONE));}
    @Test
    public void shouldReturn3WhenSum1And2 () { assertEquals (THREE, out.plus(ONE, TWO));}
    @Test
    public void shouldReturn1WhenSubtract2And1 () { assertEquals (ONE, out.minus(TWO, ONE));}
    @Test
    public void shouldReturn2WhenSubtract3And1 () { assertEquals (TWO, out.minus(THREE, ONE));}
    @Test
    public void shouldReturn3WhenMultiply3And1 () { assertEquals (THREE, out.multiply(THREE, ONE));}
    @Test
    public void shouldReturn0WhenMultiply0And3 () { assertEquals (ZERO, out.multiply(ZERO, THREE));}
    @Test
    public void shouldReturn2Divide2And1 () { assertEquals (TWO, out.divide(TWO, ONE));}
    @Test
    public void shouldReturn1Divide3And3 () { assertEquals (ONE, out.divide(THREE, THREE));}
    @Test
    public void shouldThrowZeroDivideExceptionWhenAnyNumbDivide0 () {
        assertThrows(ZeroDivideException.class, () -> out.divide(ONE, ZERO));
    }

}
