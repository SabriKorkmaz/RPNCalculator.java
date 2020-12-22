package com.rncalc;

import com.rncalc.CalculatorEngine.CalculatorEngine;
import com.rncalc.Enum.OperationType;
import com.rncalc.Helper.StringHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Stack;

public class RNCalculator extends JFrame {
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
    private JLabel labelCurrentNumber;
    private JLabel labelValues;
    private JPanel panel2;

    private CalculatorEngine engine;

    public RNCalculator() {
        add(panel1);
        setTitle("RNCalculator");
        setSize(400, 400);
        engine = new CalculatorEngine();
        //<editor-fold desc="btnNumbers">
        btnNumber1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.joinNumber(labelCurrentNumber.getText(), 1, engine.currentNumberSign()));
            }
        });
        btnNumber2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.joinNumber(labelCurrentNumber.getText(), 2, engine.currentNumberSign()));
            }
        });
        btnNumber3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.joinNumber(labelCurrentNumber.getText(), 3, engine.currentNumberSign()));

            }
        });
        btnNumber4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.joinNumber(labelCurrentNumber.getText(), 4, engine.currentNumberSign()));
            }
        });
        btnNumber5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.joinNumber(labelCurrentNumber.getText(), 5, engine.currentNumberSign()));
            }
        });
        btnNumber6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.joinNumber(labelCurrentNumber.getText(), 6, engine.currentNumberSign()));
            }
        });
        btnNumber7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.joinNumber(labelCurrentNumber.getText(), 7, engine.currentNumberSign()));
            }
        });
        btnNumber8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.joinNumber(labelCurrentNumber.getText(), 8, engine.currentNumberSign()));

            }
        });
        btnNumber9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.joinNumber(labelCurrentNumber.getText(), 9, engine.currentNumberSign()));
            }
        });
        btnNumber0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(engine.multiplyNumber(labelCurrentNumber.getText(), 10));
            }
        });
        btnNumberDoubleZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(engine.multiplyNumber(labelCurrentNumber.getText(), 100));
            }
        });
        //</editor-fold>
        //<editor-fold desc="btnFunctions">
        btnSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.operation(OperationType.Sum);
                labelValues.setText(engine.renderDataPool());
            }
        });
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.operation(OperationType.Multiply);
                labelValues.setText(engine.renderDataPool());
            }
        });
        btnSubtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.operation(OperationType.Subtract);
                labelValues.setText(engine.renderDataPool());
            }
        });
        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.operation(OperationType.Divide);
                labelValues.setText(engine.renderDataPool());
            }
        });
        btnAc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(engine.resetCalculator());
            }
        });
        btnNumberType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.changeNumberSign();
                labelCurrentNumber.setText(new BigDecimal(labelCurrentNumber.getText()).multiply(new BigDecimal(-1)).toString());
            }
        });
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.push(labelCurrentNumber.getText());
                labelValues.setText(engine.renderDataPool());
                labelCurrentNumber.setText(engine.resetCalculator());
            }
        });
        btnSeparator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentNumber.setText(StringHelper.addSeparator(labelCurrentNumber.getText()));
            }
        });
        //</editor-fold>
    }


}
