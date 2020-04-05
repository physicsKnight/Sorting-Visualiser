package com.sharifee;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.*;
import java.util.Random;

public class Visualiser extends JPanel {

    private static final int CELLSIZE = 10;
    private static final int BARS = 1280 / CELLSIZE;
    private int[] array = new int[BARS];
    private static String[] options = {"bubble sort", "selection sort", "insertion sort", "merge sort", "quick sort"};
    private JComboBox<String> algorithmList = new JComboBox<>(options);
    private JButton sortBtn = new JButton();
    private JButton shuffleBtn = new JButton();

    public Visualiser() {
        sortBtn.setText("Sort");
        shuffleBtn.setText("shuffle");
        algorithmList.setBounds(5, 5, 200, 50);
        sortBtn.setBounds(250, 5, 100, 50);
        shuffleBtn.setBounds(350, 5, 100, 50);
        initBoard();

        sortBtn.addActionListener(e -> {
            SortAlgorithm.algorithms.get(algorithmList.getSelectedIndex()).sort(array);
            repaint();
        });

        shuffleBtn.addActionListener(e -> randomise());
    }

    private void initBoard() {
        for (int i = 0; i < array.length; i++)
            array[i] = i;

        add(algorithmList);
        add(sortBtn);
        add(shuffleBtn);
        randomise();
    }

    private void delay(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void randomise() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randIndex = rand.nextInt(array.length);
            int temp = array[randIndex];
            array[randIndex] = array[i];
            array[i] = temp;
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        setBackground(Color.DARK_GRAY);
        g2d.setColor(Color.CYAN);
        drawBars(g2d);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

    private void drawBars(Graphics2D g2d) {
        for (int i = 0; i < array.length; i++) {
            int height = array[i] << 2;
            int x = i * CELLSIZE;
            int y = 700 - (height + 20);
            g2d.fillRect(x, y, CELLSIZE, height);
        }
    }
}
