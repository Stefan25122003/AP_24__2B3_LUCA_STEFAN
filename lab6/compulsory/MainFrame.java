package org.example;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);


        configPanel.drawingPanel = canvas;


        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);


        pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
}
}