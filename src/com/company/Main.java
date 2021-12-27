package com.company;


import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {

        EventQueue.invokeLater(() -> {
        Spelyta ex = new Spelyta();
        ex.setVisible(true);
        });


    }
}
