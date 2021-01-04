package com.company;

import java.util.Scanner;

public class UserInput {
    private String text;
    private int number;

    Scanner scnr = new Scanner(System.in);

    public String textInput() {

        while (!scnr.hasNext("[A-Za-z]+")) {
            System.out.println("invalid input, characters only");
            scnr.nextLine();
        }

        text = scnr.nextLine();

        if (text.equalsIgnoreCase("q")) {
            scnr.close();
            System.exit(0);
        }

        return text;
    }

    public int numberInput() {

        while (!scnr.hasNext("[0-9]+")) {
            System.out.println("invalid input, numbers only");
            scnr.nextInt();
        }
        number = scnr.nextInt();
        return number;
    }
}
