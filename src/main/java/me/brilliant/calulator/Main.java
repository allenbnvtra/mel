package main.java.me.brilliant.calulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener {
    private JFrame CalculatorFrame;
    private JPanel CalculatorPanel;
    private JLabel operation, result;

    public static void main(String[] args) {
        Main main = new Main();
        main.showBasicCalculatorLayout();
    }


    private void showBasicCalculatorLayout() {
        CalculatorFrame = new JFrame("Calculator");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 760) / 2);
        int y = (int) ((dimension.getHeight() - 660) / 2);
        CalculatorFrame.setBounds(x, y, 760, 660);
        CalculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalculatorFrame.setResizable(false);
        CalculatorPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        CalculatorPanel.setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        Font font = new Font("saxmono", Font.PLAIN, 36);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        String[] buttonsContent = {"7", "8", "9", "AC", "Del", "4", "5", "6", "+", "(", "1", "2", "3", "-", ")", "0", "*", "/", ".", "="};
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        operation = new JLabel("", SwingConstants.LEFT);
        operation.setFont(font);
        operation.setPreferredSize(new Dimension(700, 80));
        CalculatorPanel.add(operation, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        result = new JLabel("", SwingConstants.RIGHT);
        result.setFont(font);
        result.setPreferredSize(new Dimension(700, 80));
        CalculatorPanel.add(result, gridBagConstraints);
        int gridy = 2;
        int gridx = 0;
        for (int i = 0; i < buttonsContent.length; i += 1) {
            gridBagConstraints.gridx = gridx;
            gridBagConstraints.gridy = gridy;
            gridBagConstraints.gridwidth = 1;
            JButton button = new JButton(buttonsContent[i]);
            button.addActionListener(this);
            button.setFont(font);
            button.setPreferredSize(new Dimension(140, 80));
            CalculatorPanel.add(button, gridBagConstraints);
            if ((i + 1) % 5 == 0) {
                gridy++;
                gridx = 0;
            } else
                gridx += 1;
        }

        font = new Font("saxmono", Font.PLAIN, 28);



        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        JButton programmer = new JButton("Programmer View");
        programmer.addActionListener(this);
        programmer.setFont(font);
        programmer.setPreferredSize(new Dimension(420, 80));
        CalculatorPanel.add(programmer, gridBagConstraints);


        CalculatorFrame.add(CalculatorPanel);
        CalculatorFrame.setVisible(true);
    }

    private void showProgrammerCalculatorLayout() {
        CalculatorFrame = new JFrame("Programmer Calculator");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 900) / 2);
        int y = (int) ((dimension.getHeight() - 860) / 2);
        CalculatorFrame.setBounds(x, y, 900, 860);
        CalculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalculatorFrame.setResizable(false);
        CalculatorPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        CalculatorPanel.setLayout(gridBagLayout);


        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        Font font = new Font("saxmono", Font.PLAIN, 36);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        String[] buttonsContent = {
                "9", "8", "7", "6", "5", "4",
                "3", "2", "1", "0", "AC", "-",
                "+", "*", "/", "=", "tobin", "tooct",
                "tohex", ">>", "<<", "A", "B", "C", "D",
                "E", "F", "Del", "(", ")",
        };

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        operation = new JLabel("", SwingConstants.LEFT);
        operation.setFont(font);
        operation.setPreferredSize(new Dimension(840, 80));
        CalculatorPanel.add(operation, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        result = new JLabel("", SwingConstants.RIGHT);
        result.setFont(font);
        result.setPreferredSize(new Dimension(840, 80));
        CalculatorPanel.add(result, gridBagConstraints);


        int gridy = 2;
        int gridx = 0;
        for (int i = 0; i < buttonsContent.length; i += 1) {
            gridBagConstraints.gridx = gridx;
            gridBagConstraints.gridy = gridy;
            gridBagConstraints.gridwidth = 1;
            JButton button = new JButton(buttonsContent[i]);
            button.addActionListener(this);
            button.setFont(font);
            button.setPreferredSize(new Dimension(140, 80));
            CalculatorPanel.add(button, gridBagConstraints);
            if ((i + 1) % 6 == 0) {
                gridy++;
                gridx = 0;
            } else
                gridx += 1;
        }



        font = new Font("saxmono", Font.PLAIN, 28);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 6;
        JButton basic = new JButton("Basic View");
        basic.addActionListener(this);
        basic.setFont(font);
        basic.setPreferredSize(new Dimension(420, 80));
        CalculatorPanel.add(basic, gridBagConstraints);




        CalculatorFrame.add(CalculatorPanel);
        CalculatorFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals("=")) {
            if (!operation.getText().isEmpty()) {
                try {
                    result.setText(String.valueOf((long)Expression.evaluate(operation.getText())));
                } catch (Exception exception) {
                    result.setText(exception.getMessage());
                }
            } else {
                result.setText("Syntax Error");
            }
        } else if (((JButton) e.getSource()).getText().equals("Basic View")) {
            CalculatorFrame.setVisible(false);
            showBasicCalculatorLayout();
        }  else if (((JButton) e.getSource()).getText().equals("Programmer View")) {
            CalculatorFrame.setVisible(false);
            showProgrammerCalculatorLayout();
        } else if (((JButton) e.getSource()).getText().equals("AC")) {
            result.setText("");
            operation.setText("");
        } else if (((JButton) e.getSource()).getText().equals("Del")) {
            operation.setText((operation.getText() == null || operation.getText().length() == 0) ? operation.getText() : operation.getText().substring(0, operation.getText().length() - 1));
        } else {
            JButton jButton = (JButton) e.getSource();
            String buttonText = jButton.getText();
            operation.setText(operation.getText() + buttonText);
            Font font = new Font("saxmono", Font.PLAIN, 28);
            result.setFont(font);
        }
    }

}