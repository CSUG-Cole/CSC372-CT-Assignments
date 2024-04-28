package com.csc372.module_2;

/*
 * Create a simple GUI application that will obtain the birth date from a user.
 * The program must then calculate and display the age of the user within a JPanel
 * when the user selects a button. The GUI should display the value presented.
 * Ensure that your application includes the following components:
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Main
{
    public static void main(String[] args) {
        /* Create the main window */
        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 200));

        /* Create the panel to manage components */
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        /* Create message label, birthday field, and age button */
        JLabel errorLabel = new JLabel("");
        JLabel messageLabel = new JLabel("Please enter your birthday in MM/DD/YYYY format.");
        JTextField textField = new JTextField(20);
        JButton calculateAgeButton = new JButton("Calculate age");

        /* Add all components to the panel with some spacing */
        panel.add(Box.createVerticalStrut(10));
        panel.add(errorLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(messageLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Birthdate:"));
        panel.add(textField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(calculateAgeButton);
        panel.add(Box.createVerticalStrut(10));

        /* Define button behavior when clicked */
        calculateAgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birthday = textField.getText();
                if (birthday.isEmpty()) {
                    errorLabel.setText("Nothing entered.");
                    messageLabel.setText("Please enter your birthday in MM/DD/YYYY format.");
                    return;
                }
                try {
                    errorLabel.setText("");
                    LocalDate birthdateObj = LocalDate.parse(
                        birthday, DateTimeFormatter.ofPattern("MM/dd/yyyy")
                    );
                    LocalDate currentDate = LocalDate.now();

                    long age = ChronoUnit.YEARS.between(birthdateObj, currentDate);

                    messageLabel.setText("Your age is: " + age + " years");
                } catch (DateTimeParseException perror) {
                    errorLabel.setText("Birthday not formatted correctly.");
                    messageLabel.setText("Please enter your birthday in MM/DD/YYYY format.");
                }
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
