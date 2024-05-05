package com.csc372.module_3;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu extends JFrame {
    /* Program constants */
    private JTextArea textArea;
    private JPanel panel;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final float greenHue = 0.33f;
    private final float saturation = (float) Math.random();
    private final float brightness = 0.5f + (float) Math.random() * 0.5f;
    private final Color backgroundColor = Color.getHSBColor(greenHue, saturation, brightness);

    public Menu() {
        /* Initialize the frame */
        super("Menu GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        /* Main panel with some padding to see the background */
        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel, BorderLayout.CENTER);

        /* Create the text area */
        textArea = new JTextArea();
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        /* Create the menu bar */
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        setJMenuBar(menuBar);

        /* Create menu items */
        JMenuItem dateItem = new JMenuItem("Insert Date and Time");
        JMenuItem saveItem = new JMenuItem("Save Text Area to Log");
        JMenuItem colorItem = new JMenuItem("Change Background Color");
        JMenuItem exitItem = new JMenuItem("Exit");

        /* Add menu items to the menu */
        menu.add(dateItem);
        menu.add(saveItem);
        menu.add(colorItem);
        menu.add(exitItem);

        /* Action for showing date and time */
        dateItem.addActionListener(e -> {
            textArea.append(sdf.format(new Date()));
        });

        /* Action for saving to a file */
        saveItem.addActionListener(e -> {
            try (PrintWriter out = new PrintWriter(new FileWriter("log.txt"))) {
                out.println(textArea.getText());
                JOptionPane.showMessageDialog(this, "Data saved to log.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing to file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        /* Action for changing background color to a green with random saturation and brightness */
        colorItem.addActionListener(e -> {
            panel.setBackground(backgroundColor);
        });

        /* Action for exiting the program */
        exitItem.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
}
