package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreFrame extends JFrame implements ActionListener {
    static final int width = 750;
    static final int height = 375;
    JLabel score = new JLabel("The current High-Score is: " + GamePanel.ScoreClass.getScore());
    JButton button = new JButton("Back");

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
