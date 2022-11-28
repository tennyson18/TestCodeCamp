package com.Graham;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome");
        System.out.println("This is my first ever Java lines of code.");
        System.out.print("For so long, I've heard how complicated Java is compared to Python & Javascript.");
        System.out.println("For sure I can say, yes it is more complicated.");
        System.out.println("More syntax and lines just to execute one thing.");
        System.out.println("If you're reading this, I don't want to bore you. Let's do something fun!");

        System.out.println("I'd like to know you! What is your name? *Type name in next line of this console & press enter*");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello "+ name +" nice to meet you! \uD83E\uDD1D \uD83D\uDE0E");
    }
}



