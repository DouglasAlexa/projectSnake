package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreFrame extends JFrame implements ActionListener {
    static final int width = 750;
    static final int height = 375;
    JLabel score = new JLabel(GamePanel.ScoreClass.getName() + " current High-Score is: " + GamePanel.ScoreClass.getScore());
    JButton button = new JButton("Back");

    ScoreFrame() {
        this.setTitle("High-Score");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);
        this.setLayout(new GridLayout(0, 1));
        this.setResizable(false);
        this.setVisible(true);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setVerticalAlignment(SwingConstants.CENTER);
        score.setFont(new Font("arial", Font.BOLD, 25));
        this.add(score);
        this.add(button);
        this.pack();
        this.setLocationRelativeTo(null);
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
