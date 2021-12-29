package com.company;

import javax.swing.*;


public class Spelyta extends JFrame {

    public Spelyta() {

        initUI();
    }

    public void initUI() {
        add(new Meny());
        pack();
        setResizable(false);
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}



