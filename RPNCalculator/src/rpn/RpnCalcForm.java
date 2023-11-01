package rpn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RpnCalcForm {
    private JTextField txtresult;
    private JButton a3Button;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton RPNButton;
    private JButton btndivision;
    private JButton btnmultiply;
    private JButton btnminus;
    private JButton btnplus;
    private JButton btnequals;
    public JPanel Rpnform;
    // Variables to store the numbers and operator
    private double operand1;
    private double operand2;
    private String operator;

    public RpnCalcForm() {
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("0");
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("2");
            }
        });
        btnplus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "+";
                storeOperand();
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("5");
            }
        });
        btnminus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "-";
                storeOperand();
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("8");
            }
        });
        btnmultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "*";
                storeOperand();
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToTextField("9");
            }
        });
        RPNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rpn r = new rpn();
                String s = null;
                try {
                    s = r.traduciRPN(r.calcolaRPN(txtresult.getText()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                txtresult.setText(s);
            }
        });
        btndivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "/";
                storeOperand();
            }
        });
        btnequals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
    }

    // Append the clicked number or operator to the text field
    private void appendToTextField(String text) {
        txtresult.setText(txtresult.getText() + text);
    }

    // Store the first operand and clear the text field
    private void storeOperand() {
        operand1 = Double.parseDouble(txtresult.getText());
        txtresult.setText("");
    }

    // Calculate the result based on the operator and display it in the text field
    private void calculateResult() {
        operand2 = Double.parseDouble(txtresult.getText());
        double result = 0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
        }

        txtresult.setText(Double.toString(result));
    }
    };