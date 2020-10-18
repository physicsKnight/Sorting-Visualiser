package com.sharifee;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.util.Random;

public class Visualiser extends JPanel {

    private static final int CELLSIZE = 10;
    private static final int BARS = 1280 / CELLSIZE;
    private int[] array = new int[BARS];
    private static String[] options = {"bubble sort", "selection sort", "insertion sort",
                                       "merge sort", "quick sort", "heap sort"};
    private JComboBox<String> algorithmList = new JComboBox<>(options);
    private JButton sortBtn = new JButton();
    private JButton shuffleBtn = new JButton();

    public Visualiser() {
        sortBtn.setText("Sort");
        shuffleBtn.setText("shuffle");
        initBoard();

        sortBtn.addActionListener(e -> {
            Thread worker = new Thread(this::runSort);
            worker.start();
        });

        shuffleBtn.addActionListener(e -> randomise());
    }

    private void runSort() {
        int index = algorithmList.getSelectedIndex();
        SortAlgorithm.algorithms[index].sort(array, this);
        repaint();
    }

    private void initBoard() {
        add(algorithmList);
        add(sortBtn);
        add(shuffleBtn);
        randomise();
    }

    void delay(int n) {
        repaint();
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void randomise() {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++)
            array[i] = i;

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
            int height = 1 + array[i] << 2;
            int x = i * CELLSIZE;
            int y = 700 - (height + 20);
            g2d.fillRect(x, y, CELLSIZE, height);
        }
    }
}
