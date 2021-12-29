package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    int bodyParts = 6;
    char direction = 'R';
    boolean gameStarted = false;
    Timer timer;

    int appleX;
    int appleY;
    int appleCount;

    Random random;

    GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.yellow);
        addKeyListener(new MyKeyInput());
        setFocusable(true);
        random = new Random();
        startGame();
    }
  public boolean check_wall_collision(){
        if(.getX() < 0 || player.getX() >= SCREEN_WIDTH * new Dimension|| player.getY() >= SCREEN_HEIGHT * new Dimension){
            return true;
        }
        return false;
    }
    public boolean check_self_collision(){
        for(int i = 1; i < player.getbody().size(); i++{
            if(player.getX() == player.getbodyParts().get(i).x && player.getY() == player.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }



    public void startGame() {
        placeApple();
        gameStarted = true;
        timer = new Timer(100, this);
        timer.start();
    }

    public void moveForward() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'R' -> x[0] += UNIT_SIZE;
            case 'L' -> x[0] -= UNIT_SIZE;
            case 'U' -> y[0] -= UNIT_SIZE;
            case 'D' -> y[0] += UNIT_SIZE;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawApple(g);
        drawSnake(g);
    }

    public void drawSnake(Graphics g) {
        // Draws the bodyparts of the snake
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.red);
            } else {
                g.setColor(new Color(180, 45, 0));
            }
            g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
        }
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {

            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            g.setColor(Color.green);
        }
    }

    public void drawApple(Graphics g) {
        if (gameStarted) {
            g.setColor(Color.green);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
        }
    }

    public void placeApple() {
        appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void collecting() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            appleCount++;
            placeApple();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStarted) {
            moveForward();
            collecting();
        }
        repaint();
    }


    public class MyKeyInput extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent k) {
            switch (k.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }

        }
    }
}
