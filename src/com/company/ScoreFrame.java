package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ScoreFrame extends JFrame implements ActionListener {
    static final int width = 750;
    static final int height = 375;
    JLabel score = new JLabel("The current High-Score is:" );

    JButton button = new JButton("Back");
    ScoreClass scoreClass = new ScoreClass();




    ScoreFrame() {

        this.setTitle("High-Score");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);
        this.setLayout(new GridLayout(0, 1));
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(score);
        this.add(button);
        button.addActionListener(this);
        score.setBounds(0, 0, 100, 50);
        score.setFont(new Font("arial", Font.BOLD, 25));
        for (Integer i : scoreClass.getScoreList()  ) {
            System.out.println(i);
            System.out.println(scoreClass.getScoreList().size());


        }
        System.out.println("Hej!");


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
