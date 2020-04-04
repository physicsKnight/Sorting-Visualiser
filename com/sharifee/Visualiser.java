package com.sharifee;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Random;

public class Visualiser extends JPanel {

    private int[] array;
    private static final int CELLSIZE = 10;
    private static final int BARS = 1280 / CELLSIZE;
    private static String[] options = {"bubble sort", "selection sort", "insertion sort", "merge sort", "quick sort"};
    private JComboBox<String> algorithmList;
    private JButton sortBtn;

    public Visualiser() {
        //setLayout(null);
        array = new int[BARS];
        algorithmList = new JComboBox<>(options);
        sortBtn = new JButton();
        algorithmList.setBounds(5, 5, 200, 50);
        sortBtn.setBounds(20, 5, 100, 50);
        initBoard();

        sortBtn.addActionListener(e -> {
            SortAlgorithm.algorithms.get(algorithmList.getSelectedIndex()).sort(array);
            repaint();
        });
    }

    private void initBoard() {
        for (int i = 0; i < array.length; i++)
            array[i] = i;

        add(algorithmList);
        add(sortBtn);
        randomise();
    }

    private void randomise() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randIndex = rand.nextInt(array.length);
            int temp = array[randIndex];
            array[randIndex] = array[i];
            array[i] = temp;
        }
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
