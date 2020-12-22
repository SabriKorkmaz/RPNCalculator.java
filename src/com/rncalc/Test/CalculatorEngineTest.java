package com.rncalc.Test;

import com.rncalc.CalculatorEngine.CalculatorEngine;
import com.rncalc.CalculatorEngine.ICalculatorEngine;
import com.rncalc.Enum.OperationType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorEngineTest {
    CalculatorEngine engine = new CalculatorEngine();

    @Test
    public void resetCalculator_emptyParameters_emptyString() {
        assertEquals("0", engine.resetCalculator());
    }

    @Test
    public void multiplyNumber_number0_0() {
        assertEquals("100", engine.multiplyNumber("10", 10));
    }

    @Test
    public void multiplyNumber_negativeCurrentNumber10number10_minus100() {
        assertEquals("-100", engine.multiplyNumber("-10", 10));
    }

    @Test
    public void multiplyNumber_positiveCurrentNumber30number10_300() {
        assertEquals("-300", engine.multiplyNumber("-30", 10));
    }

    @Test
    public void multiplyNumber_positiveCurrentNumber10negativeNumber10_minus100() {
        assertEquals("-100", engine.multiplyNumber("10", -10));
    }

    @Test
    public void renderDataPool_emptyPool_emptyString() {
        assertEquals("", engine.renderDataPool());
    }

    @Test
    public void renderDataPool_specifiedString_5power3power4() {
        engine.clear();
        engine.push("5");
        engine.push("3");
        engine.push("4");
        assertEquals("5^3^4^", engine.renderDataPool());
    }

    @Test
    public void renderDataPool_specifiedString_3point2power3() {
        engine.clear();
        engine.push("3");
        engine.push("3.2");
        assertEquals("3^3.2^", engine.renderDataPool());
    }

    @Test
    public void operation_sumSpecifiedArray_42() {
        engine.clear();
        engine.push("3");
        engine.push("39");
        assertEquals(new BigDecimal(42), engine.operation(OperationType.Sum).firstElement());
    }

    @Test
    public void operation_multiplySpecifiedArray_100() {
        engine.clear();
        engine.push("25");
        engine.push("4");
        assertEquals(new BigDecimal(100), engine.operation(OperationType.Multiply).firstElement());
    }

    @Test
    public void operation_divideSpecifiedArray_1() {
        engine.clear();
        engine.push("4");
        engine.push("20");
        assertEquals(new DecimalFormat("0.00").format(new BigDecimal(0.2)), new DecimalFormat("0.00").format(engine.operation(OperationType.Divide).firstElement()));
    }

    @Test
    public void operation_subtractSpecifiedArray_minus16() {
        engine.clear();
        engine.push("4");
        engine.push("20");
        assertEquals(new BigDecimal(-16), engine.operation(OperationType.Subtract).firstElement());
    }

    @Test
    public void operation_sumSpecifiedArray_24() {
        engine.clear();
        engine.push("4");
        engine.push("20");
        assertEquals(new BigDecimal(24), engine.operation(OperationType.Sum).firstElement());
    }

    @Test
    public void operation_multiply2point5to8_20() {
        engine.clear();
        engine.push("8");
        engine.push("2.5");
        assertEquals(new DecimalFormat("0.00").format(20), new DecimalFormat("0.00").format(engine.operation(OperationType.Multiply).firstElement()));
    }

    @Test
    public void operation_divide10to3_3point33() {
        engine.clear();
        engine.push("3");
        engine.push("10");
        assertEquals(new BigDecimal(30), engine.operation(OperationType.Multiply).firstElement());
    }

    @Test
    public void operation_subtractSecondIndex10toFirstIndex2_negative8() {
        engine.clear();
        engine.push("2");
        engine.push("10");
        assertEquals(new BigDecimal(-8), engine.operation(OperationType.Subtract).firstElement());
    }

    @Test
    public void push_0_firstItemZero() {
        engine.clear();
        assertEquals(new BigDecimal(0), engine.push("0").firstElement());
    }

    @Test
    public void push_0and9_length2() {
        engine.clear();
        engine.push("0");
        assertEquals(2, engine.push("9").size());
    }

}
