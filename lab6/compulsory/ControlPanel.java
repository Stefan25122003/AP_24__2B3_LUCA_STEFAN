package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn;
    JButton saveBtn;
    JButton exitBtn;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 3)); // Change layout to accommodate buttons

        loadBtn = new JButton("Load");
        saveBtn = new JButton("Save");
        exitBtn = new JButton("Exit");

        // Add action listeners to buttons
        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement load functionality here
                JOptionPane.showMessageDialog(frame, "Load functionality not implemented yet.");
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement save functionality here
                JOptionPane.showMessageDialog(frame, "Save functionality not implemented yet.");
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                frame.dispose();
            }
        });

        // Add buttons to panel
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);
    }
}