package com.rncalc.CalculatorEngine;

import com.rncalc.Enum.OperationType;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

public class CalculatorEngine implements ICalculatorEngine {

    private Stack<BigDecimal> _dataPool;
    private int sign;

    public CalculatorEngine() {
        _dataPool = new Stack();
        sign = 1;
    }

    public Stack operation(OperationType type) {
        if (_dataPool.size() == 1) return _dataPool;
        BigDecimal val1, val2;
        switch (type) {
            case Sum:
                _dataPool.push(_dataPool.pop().add(_dataPool.pop(), MathContext.DECIMAL128));
                break;
            case Subtract:
                val1 = _dataPool.pop();
                val2 = _dataPool.pop();
                _dataPool.push(val2.subtract(val1, MathContext.DECIMAL128));
                break;
            case Multiply:
                _dataPool.push(_dataPool.pop().multiply(_dataPool.pop(), MathContext.DECIMAL128));
                break;
            case Divide:
                val1 = _dataPool.pop();
                val2 = _dataPool.pop();
                _dataPool.push(val2.divide(val1, MathContext.DECIMAL128));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return _dataPool;
    }


    public String renderDataPool() {
        String value = "";
        for (int j = (_dataPool.size() - 1); j >= 0; j--) {
            value = (_dataPool.elementAt(j)) + "^" + value;
        }
        return value;
    }


    public String multiplyNumber(String currentNumber, int number) {
        return new BigDecimal(currentNumber).multiply(BigDecimal.valueOf(number)).toString();
    }

    public String resetCalculator() {
        sign = 1;
        return "0";
    }

    public Stack push(String currentNumber) {
        _dataPool.push(new BigDecimal(currentNumber));
        return _dataPool;
    }

    public Stack clear() {
        _dataPool.clear();
        return _dataPool;
    }

    public int changeNumberSign() {
        sign *= -1;
        return sign;
    }

    public int currentNumberSign() {
        return sign;
    }
}
