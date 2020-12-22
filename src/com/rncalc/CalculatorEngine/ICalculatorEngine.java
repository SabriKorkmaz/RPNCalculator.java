package com.rncalc.CalculatorEngine;
import com.rncalc.Enum.OperationType;
import java.util.Stack;

public interface ICalculatorEngine {
    String resetCalculator();
    String multiplyNumber(String currentNumber,int number);
    String renderDataPool();
    Stack operation(OperationType type);
    Stack push(String currentNumber);
    Stack clear();
    int changeNumberSign();
    int currentNumberSign();
}
