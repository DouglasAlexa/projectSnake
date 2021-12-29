package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

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
    Timer timer2;

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
        if (gameStarted) {
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(new Color(180, 45, 0));
                }
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
        else {
            gameOver(g);
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

    public void collisonCheck() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && ((y[0] == y[i]))) {
                gameStarted = false;
                break;
            }
        }
        if ((x[0] < 0) || x[0] > SCREEN_WIDTH)
            gameStarted = false;

        if((y[0] < 0) || y[0] > SCREEN_HEIGHT)
             gameStarted = false;

        if(!gameStarted){
            timer.stop();

        }

    }


    public void gameOver(Graphics g) {
        gameStarted = false;
        timer.stop();
        g.setFont(new Font("Verdana", Font.BOLD, 52));
        g.setColor(new Color(25, 25, 25));
        FontMetrics metricsGame = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metricsGame.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
        g.setFont(new Font("Verdana", Font.PLAIN, 38));
        FontMetrics metricsScore = getFontMetrics(g.getFont());
        g.drawString("Score: " + appleCount, (SCREEN_WIDTH - metricsScore.stringWidth("Score: " + appleCount)) / 2, SCREEN_HEIGHT - g.getFont().getSize());
        timer2 = new Timer(3000, this);
        timer2.setRepeats(false);
        timer2.start();
    }

    public void dispose() {
        JFrame parent = (JFrame) this.getTopLevelAncestor();
        parent.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStarted) {
            moveForward();
            collecting();
            collisonCheck();

        } else {
            timer2.stop();
            JFrame test = new JFrame();
            test.setVisible(true);
            test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            test.add(new Meny());
            test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            test.setResizable(false);
            test.setTitle("Snake 7 - " + getWidth() + " : " + getHeight());
            test.pack();
            test.setLocationRelativeTo(null);
            dispose();
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
