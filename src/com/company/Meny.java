package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;



public class Meny extends JPanel implements ActionListener , Serializable {
    static final int width = 1300;
    static final int height = 750;

    JButton playButton = new JButton("Start Game");
    JButton scoreButton = new JButton("Show High-Score");
    JButton exitButton = new JButton("Quit Game");
    JTextArea mainText = new JTextArea("SNAKE 7");

    Meny() {

        setPreferredSize(new Dimension(width, height));
        GridBagLayout bagLayout = new GridBagLayout();
        setLayout(bagLayout);

        add(mainText);
        mainText.setFont(new Font("Verdana", Font.PLAIN, 35));
        add(playButton);
        playButton.setPreferredSize(new Dimension(200, 100));
        playButton.addActionListener(this);
        add(scoreButton);
        scoreButton.setPreferredSize(new Dimension(200, 100));
        scoreButton.addActionListener(this);
        add(exitButton);
        exitButton.setPreferredSize(new Dimension(200, 100));
        exitButton.addActionListener(this);
        setBackground(Color.black);
    }

public void dispose(){
        JFrame parent = (JFrame) this.getTopLevelAncestor();
        parent.dispose();
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == scoreButton) {
            new ScoreFrame();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == playButton) {

            JFrame test = new JFrame();
            test.setVisible(true);
            test.setLocationRelativeTo(null);
            test.add(new GamePanel());
            test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            test.setResizable(false);
            test.setTitle("Snake 7 - " + getWidth() + " : " + getHeight());
            test.pack();
            test.setLocationRelativeTo(null);
            dispose();


        }
    }
}
