package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");

        String line = scanner.nextLine();

        List.of(line.split("")).forEach(e -> System.out.print(e + " "));
    }
}