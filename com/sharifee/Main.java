package com.sharifee;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    public Main() {
        initUI();
    }

    private void initUI() {
        add(new Visualiser());
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Sorting Visualiser");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }
}
