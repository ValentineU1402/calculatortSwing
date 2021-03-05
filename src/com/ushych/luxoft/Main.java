package com.ushych.luxoft;

import java.awt.BorderLayout;
import com.ushych.luxoft.models.MathOperation;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Main extends JFrame {

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
        tablePane.addTab("History", new JPanel());
        tablePane.setSelectedIndex(0);
        return tablePane;
    }

    private static JPanel createCalculatorPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        // GridBagConstraints bag = new GridBagConstraints();

        JTextField firstField = new JTextField(6);
        JComboBox<String> comboBox = createOperationField();
        JCheckBox checkBox = new JCheckBox("Calculate on the fly");
        JTextField secondField = new JTextField(6);

        panel.add(firstField, BorderLayout.NORTH);
        panel.add(comboBox, BorderLayout.NORTH);
        // panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(secondField, BorderLayout.NORTH);
        panel.add(checkBox);

        return panel;
    }

    private static JComboBox<String> createOperationField() {
        String[] opertions = {MathOperation.PLUS.getSymbolOperation(), MathOperation.MINUS.getSymbolOperation(),
                MathOperation.MULTIPLICATION.getSymbolOperation(), MathOperation.DIVISION.getSymbolOperation()};
        JComboBox<String> comboBox = new JComboBox<>(opertions);
        // ActionListener actionListener = new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // JComboBox<?> box = (JComboBox<?>) e.getSource();
        // String operation = (String) box.getSelectedItem();
        //
        // }
        // };
        // comboBox.addActionListener(actionListener);
        comboBox.setSize(200, 10);
        return comboBox;
    }
}
