package com.ushych.luxoft;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.ushych.luxoft.controllers.CalculateController;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class View extends JFrame {

    private static CalculateController controller = new CalculateController();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 400);

        JTabbedPane tablePane = createTableWithPanes();

        frame.getContentPane().add(tablePane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static JTabbedPane createTableWithPanes() {
        JTabbedPane tablePane = new JTabbedPane();
        tablePane.addTab("Calculator", createCalculatorPanel());
        tablePane.addTab("History", createHistoryPanel());
        tablePane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JTextArea historyField = new JTextArea(controller.getCalculateHistory());
                historyField.setEditable(false);
                JPanel component = (JPanel) tablePane.getComponentAt(1);
                component.removeAll();
                component.add(historyField);
            }
        });
        tablePane.setSelectedIndex(0);
        return tablePane;
    }

    private static JPanel createCalculatorPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel panelExpression = new JPanel();
        panelExpression.setLayout(new GridLayout(0, 3));
        JPanel panelAction = new JPanel();
        panelAction.setLayout(new FlowLayout());
        JPanel panelResult = new JPanel();
        panelResult.setLayout(new GridLayout(0, 2));

        JTextField firstField = createFilteredField();
        JComboBox<String> comboBox = createOperationField();
        JTextField secondField = createFilteredField();
        panelExpression.add(firstField);
        panelExpression.add(comboBox);
        panelExpression.add(secondField);

        JCheckBox checkBox = new JCheckBox("Calculate on the fly");
        JButton calculateButton = new JButton("Calculate");
        panelAction.add(checkBox);
        panelAction.add(calculateButton);

        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        panelResult.add(resultLabel);
        panelResult.add(resultField);

        resultField.setEditable(false);
        resultField.setHorizontalAlignment(SwingConstants.RIGHT);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = controller.calculate(firstField.getText(), comboBox.getSelectedItem().toString(),
                        secondField.getText());
                resultField.setText(result);
            }
        });

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()) {
                    String result = controller.calculate(firstField.getText(), comboBox.getSelectedItem().toString(),
                            secondField.getText());
                    resultField.setText(result);
                }
        }
        });

        panel.add(panelExpression, BorderLayout.NORTH);
        panel.add(panelAction, BorderLayout.CENTER);
        panel.add(panelResult, BorderLayout.SOUTH);
        return panel;
    }

    private static JTextField createFilteredField() {
        JTextField field = new JTextField();
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, text.replaceAll(".*[^\\d*(.)\\d*]", ""), attr);
            }
        });
        return field;

    }

    private static JComboBox<String> createOperationField() {
        String[] opertions = { "+", "-", "*", "/" };
        JComboBox<String> comboBox = new JComboBox<>(opertions);
        return comboBox;
    }

    private static JPanel createHistoryPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        return panel;
    }
}
