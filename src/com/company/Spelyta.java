package com.company;
import javax.swing.*;
import java.awt.*;


public class Spelyta extends JFrame{

         public JFrame window;
         public JPanel panel;


         public static final int width = 30;
         public static final int height = 30;
         public static final int dimension = 20;



         public Spelyta() {
             window = new JFrame();
             panel = new Meny();
             window.setTitle("Snake");
             /*window.setSize(width * dimension, height * dimension);*/
             window.setVisible(true);
             window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             panel.setBackground(Color.red);
             panel.setBorder(BorderFactory.createEmptyBorder( 0, 0 , width , height));
             panel.setVisible(true);
             window.add(panel);
             window.setResizable(false);
             window.pack();
             window.getContentPane() .setBackground( Color.black );



         }


     }



