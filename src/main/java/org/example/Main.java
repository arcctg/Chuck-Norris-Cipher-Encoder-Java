package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String binary;

        System.out.println("Input string:");

        binary = toBinary(scanner.nextLine());

        System.out.println("\nThe result:");

        System.out.println(encode(binary));
    }

    private static StringBuilder encode(String binary) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            int gg = 0;

            builder.append(binary.charAt(i) == '1' ? "0 " : "00 ");

            for (int j = i + 1; j < binary.length(); j++) {
                if (binary.charAt(j) == c) gg++;
                else break;
            }

            builder.append("0%s ".formatted("0".repeat(gg)));

            i += gg;
        }

        return builder;
    }

    private static String toBinary(String line) {
        StringBuilder binary = new StringBuilder();
        line.chars().forEach(e -> {
            binary.append(String.format("%07d", new BigInteger(Integer.toBinaryString(e))));
        });

        return binary.toString();
    }
}