package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");

        String line = scanner.nextLine();

        System.out.println("\nThe result:");

        //line.chars().forEach(e -> System.out.printf("%c = %07d\n", e, new BigInteger(Integer.toBinaryString(e))));
        for (char c : line.toCharArray()) {
            System.out.printf("%c = %07d\n", c, new BigInteger(Integer.toBinaryString(c)));
        }
    }
}