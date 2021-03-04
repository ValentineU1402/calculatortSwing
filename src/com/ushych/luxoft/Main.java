package com.ushych.luxoft;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        JPanel calculator = new JPanel();
        JPanel history = new JPanel();
        frame.getContentPane().add(calculator);
        frame.getContentPane().add(history);
        JButton button1 = new JButton("Press");
        frame.getContentPane().add(button1);
        frame.setVisible(true);
    }

}
