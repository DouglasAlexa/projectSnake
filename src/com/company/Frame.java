package com.company;

import javax.swing.*;

public class Frame extends JFrame {

    Frame(){
        this.add(new Meny());
        this.setTitle("Snake 7");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
