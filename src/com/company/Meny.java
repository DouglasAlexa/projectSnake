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
    JTextArea mainText = new JTextArea("SNAKE 7");

    Meny(){
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        GridBagLayout bagLayout = new GridBagLayout();
        
        setLayout(bagLayout);

        add(mainText);
        mainText.setFont(new Font("Verdana", Font.PLAIN, 35));
       // mainText.setVerticalAlignment(SwingConstants.TOP);
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == scoreButton){
            new ScoreFrame();
        }
        else if (e.getSource() == exitButton){
            System.exit(0);
        }
        else if (e.getSource() == playButton) {
            removeAll();
            add(new GamePanel());
            repaint();
            invalidate();
            validate();

        }
    }
}
