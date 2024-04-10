package org.example;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    DrawingPanel drawingPanel; // reference to DrawingPanel

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        // the label and the spinner
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        // a listener to the spinner to detect changes
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Get the new value from the spinner
                int newValue = (int) spinner.getValue();
                // Update the grid size in the drawing panel
                if (drawingPanel != null) {
                    drawingPanel.updateGridSize(newValue, newValue);
                }
            }
        });

        // label and spinner to panel
        add(label);
        add(spinner);
    }

    public int getRows() {
        return (int) spinner.getValue();
    }

    public int getCols() {
        return (int) spinner.getValue();
}
}