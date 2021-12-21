package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meny extends JPanel implements ActionListener {
    static final int width = 1300;
    static final int height = 750;
    JButton playButton = new JButton("Start Game");
    JButton scoreButton = new JButton("Show High-Score");
    JButton exitButton = new JButton("Quit Game");
    
    Meny(){
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);
        this.setLayout(new GridLayout(0, 1));
        this.add(playButton);
        this.add(scoreButton);
        scoreButton.addActionListener(this);
        this.add(exitButton);
        exitButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == scoreButton){
            new ScoreFrame();
        }
        else if (e.getSource() == exitButton){
            System.exit(0);
            }
        }
    }
