package org.example;

import java.util.Scanner;

public class InputParser {

    private static InputParser instance;

    private InputParser() {
    }

    public static InputParser getInstance() {
        if (instance == null) {
            instance = new InputParser();
        }
        return instance;
    }

    public String parseInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

}
