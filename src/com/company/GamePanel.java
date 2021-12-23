package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    boolean gameStarted = false;
    Timer timer;
    char direction = 'R';

    GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.yellow);
        this.setFocusable(true);
        startGame();
    }

    public void startGame(){
        timer = new Timer(1000, this);
        gameStarted = true;
        timer.start();
    }

    public void moveForward(){
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction){
            case 'R'->x[0] += UNIT_SIZE;
            case 'L'->x[0] -= UNIT_SIZE;
            case 'U'->y[0] -= UNIT_SIZE;
            case 'D'->y[0] += UNIT_SIZE;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSnake(g);
    }

    public void drawSnake(Graphics g) {
        // Draws the bodyparts of the snake
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.red);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                g.setColor(new Color(180, 45, 0));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStarted){
            moveForward();
        }
        repaint();
    }
}
