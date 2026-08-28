package com.example.demo.garbage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;

public class ButtonExample {
    public static void main(String[] args) {
        System.out.println("Main method started on thread: " + Thread.currentThread().getName());

        // Run UI creation on the Swing Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            System.out.println("UI creation running on thread: " + Thread.currentThread().getName());

            // 1. Create the window and the button
            JFrame frame = new JFrame("Observer Pattern Example");
            JButton myButton = new JButton("Click Me!");

            // 2. Add the ActionListener (The Observer)
            // Put your breakpoint on the line below to debug the ActionEvent when clicked
            myButton.addActionListener((ActionEvent e) -> {
                System.out.println("\n=== Button Clicked! ===");
                System.out.println("ActionListener running on thread: " + Thread.currentThread().getName());
                System.out.println("Action Command: " + e.getActionCommand());
                System.out.println("Source: " + e.getSource());
                System.out.println("When (timestamp): " + e.getWhen());
                System.out.println("Modifiers: " + e.getModifiers());
                System.out.println("Event Object Details: " + e.paramString());
            });

            // 3. Standard setup to show the window
            frame.add(myButton);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null); // Center on screen
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        System.out.println("Main method finished on thread: " + Thread.currentThread().getName());
    }
}
