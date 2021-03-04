package com.ushych.luxoft;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Main extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 500);
        
        JTabbedPane tablePane = createTablePane();

        frame.getContentPane().add(tablePane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static JTabbedPane createTablePane() {
        JTabbedPane tablePane = new JTabbedPane();
        tablePane.addTab("Calculator", new JPanel());
        tablePane.addTab("History", new JPanel());
        tablePane.setSelectedIndex(0);
        return tablePane;
    }

}
