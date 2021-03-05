package com.ushych.luxoft;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Main extends JFrame {

    private static CalculateController controller = new CalculateController();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 500);

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
                // historyField.setHorizontalAlignment(JTextField.CENTER);
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
        panel.setLayout(new GridLayout(3, 3));

        JTextField firstField = new JTextField(6);
        JComboBox<String> comboBox = createOperationField();
        JTextField secondField = new JTextField(6);
        JCheckBox checkBox = new JCheckBox("Calculate on the fly");
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
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

        panel.add(firstField);
        panel.add(comboBox);
        panel.add(secondField);
        panel.add(checkBox);
        panel.add(calculateButton);

        panel.add(resultLabel);
        panel.add(resultField);

        return panel;
    }

    private static JComboBox<String> createOperationField() {
        String[] opertions = {"+", "-", "*", "/"};
        JComboBox<String> comboBox = new JComboBox<>(opertions);
        return comboBox;
    }

    private static JPanel createHistoryPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        return panel;
    }
}
