package com.rncalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Stack;

public class RNCalculator2 extends JFrame {
    //<editor-fold desc="btnNumberVariables">
    private JPanel panel1;
    private JButton btnNumber1;
    private JButton btnNumber2;
    private JButton btnNumber3;
    private JButton btnNumber4;
    private JButton btnNumber5;
    private JButton btnNumber6;
    private JButton btnNumber7;
    private JButton btnNumber8;
    private JButton btnNumber9;
    private JButton btnNumber0;
    private JButton btnNumberDoubleZero;
    //</editor-fold>
    //<editor-fold desc="btnFunctionVariables">
    private JButton btnSum;
    private JButton btnSubtract;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JButton btnAc;
    private JButton btnNumberType;
    private JButton btnInsert;
    private JButton btnSeparator;
    //</editor-fold>

    private Stack<BigDecimal> _dataPool = new Stack<BigDecimal>();

    private BigDecimal _currentNumber = new BigDecimal(0);
    private boolean isNegative = false;
    private boolean isCalculated = false;
    private JLabel labelCurrentNumber;
    private JLabel labelValues;
    private JPanel panel2;

    public RNCalculator2() {
        add(panel1);
        setTitle("RNCalculator");
        setSize(400, 400);

        //<editor-fold desc="btnNumbers">
        btnNumber1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(addNumber(1));
            }
        });
        btnNumber2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(addNumber(2));
            }
        });
        btnNumber3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(addNumber(3));
            }
        });
        btnNumber4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(addNumber(4));
            }
        });
        btnNumber5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(addNumber(5));
            }
        });
        btnNumber6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(addNumber(6));
            }
        });
        btnNumber7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(addNumber(7));
            }
        });
        btnNumber8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(addNumber(8));
            }
        });
        btnNumber9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(addNumber(9));
            }
        });
        btnNumber0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(multiplyNumber(10));
            }
        });
        btnNumberDoubleZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(multiplyNumber(100));
            }
        });
        //</editor-fold>
        //<editor-fold desc="btnFunctions">
        btnSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(sum(_dataPool, _currentNumber));

                renderLabels();
            }
        });
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(multiply(_dataPool, _currentNumber));
                renderLabels();
            }
        });
        btnSubtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(subtract(_dataPool, _currentNumber));
                renderLabels();
            }
        });
        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(divide(_dataPool, _currentNumber));
                renderLabels();
            }
        });
        btnAc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderCurrentNumber(resetCalculator());
            }
        });
        btnNumberType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isNegative = !isNegative;
                renderCurrentNumber(currentNumberSign() + labelCurrentNumber.getText().replace("-", ""));
            }
        });
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _dataPool.push(_currentNumber);
                renderLabels();
                renderCurrentNumber(resetCalculator());
            }
        });
        btnSeparator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(addSeperator(labelCurrentNumber.getText()));
            }
        });
        //</editor-fold>
    }

    String addSeperator(String value) {
        if (value.contains(".")) return value;
        else return value + ".";
    }

    void renderLabels() {
        String value = "";
        for (int j = (_dataPool.size() - 1); j >= 0; j--) {
            value = String.valueOf(_dataPool.elementAt(j)) + "^" + value;
        }
        labelValues.setText(value);
    }

    void renderCurrentNumber(String value) {
        _currentNumber = new BigDecimal(value.replace(",", ""));
        String formattedValue = formatStr(_currentNumber);
        labelCurrentNumber.setText(formattedValue);
    }

    String addNumber(int newValue) {
        if (labelCurrentNumber.getText() == "0" || isCalculated) {
            isCalculated = false;
            return formatStr(new BigDecimal(newValue));
        }
        var currentValue = labelCurrentNumber.getText().replace("-", "");
        if (currentValue.contains(".")) {
            var numberParts = currentValue.split("\\.", -1);
            return currentNumberSign() + numberParts[0] + "." + numberParts[1] + newValue;
        }
        return currentNumberSign() + currentValue + newValue;
    }

    String multiplyNumber(int number) {
        _currentNumber = _currentNumber.multiply(BigDecimal.valueOf(number));
        return String.valueOf(_currentNumber);
    }

    String formatStr(BigDecimal val) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setMaximumFractionDigits(10);
        formatter.setRoundingMode(RoundingMode.DOWN);
        return formatter.format(val);
    }

    String resetCalculator() {
        isNegative = false;
        return "0";
    }

    String currentNumberSign() {
        return isNegative ? "-" : "";
    }

    String sum(Stack pool, BigDecimal currentNumber) {
        if (pool.empty() || (pool.size() == 1 && currentNumber.longValue() == 0)) return currentNumber.toString();
        var targetNumber = pool.lastElement();
        var result = new BigDecimal(targetNumber.toString()).add(currentNumber.intValue() == 0 ? new BigDecimal(pool.elementAt(pool.size() - 2).toString()) : currentNumber,MathContext.DECIMAL128);
        updateStack(pool, currentNumber);
        return formatStr(result);
    }

    String multiply(Stack pool, BigDecimal currentNumber) {
        if (pool.empty() || (pool.size() == 1 && currentNumber.longValue() == 0)) return currentNumber.toString();
        var targetNumber = pool.lastElement();
        var result = new BigDecimal(targetNumber.toString()).multiply(currentNumber.intValue() == 0 ? new BigDecimal(pool.elementAt(pool.size() - 2).toString()) : currentNumber,MathContext.DECIMAL128);
        updateStack(pool, currentNumber);
        return formatStr(result);
    }

    String subtract(Stack pool, BigDecimal currentNumber) {
        if (pool.empty() || (pool.size() == 1 && currentNumber.longValue() == 0)) return currentNumber.toString();
        var targetNumber = pool.lastElement();
        var result = new BigDecimal(targetNumber.toString()).subtract(currentNumber.intValue() == 0 ? new BigDecimal(pool.elementAt(pool.size() - 2).toString()) : currentNumber,MathContext.DECIMAL128);
        updateStack(pool, currentNumber);
        return formatStr(result);
    }

    String divide(Stack pool, BigDecimal currentNumber) {
        if (pool.empty() || (pool.size() == 1 && currentNumber.longValue() == 0)) return currentNumber.toString();
        var targetNumber = pool.lastElement();
        var result = new BigDecimal(targetNumber.toString()).divide(currentNumber.intValue() == 0 ? new BigDecimal(pool.elementAt(pool.size() - 2).toString()) : currentNumber, MathContext.DECIMAL128);
        updateStack(pool, currentNumber);
        return formatStr(result);
    }

    Stack updateStack(Stack pool, BigDecimal currentNumber) {
        pool.removeElementAt(pool.size() - 1);
        isCalculated = true;
        if (currentNumber.longValue() == 0) pool.removeElementAt(pool.size() - 1);
        return pool;
    }
}
