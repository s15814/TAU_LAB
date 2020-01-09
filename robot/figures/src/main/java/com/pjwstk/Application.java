package com.pjwstk;

public class Application {
    public static void main(String[] args) {
        boolean result = new FigureValidator().verify(args);
        System.out.println("Can you build figure from provided sides?");
        System.out.println(result);
    }
}