package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String binary, str;

        System.out.println("Input encoded string:");

        str = scanner.nextLine();

        System.out.println("\nThe result:");

        System.out.println(decode(str));
    }

    private static StringBuilder decode(String str) {
        StringBuilder binary = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        char c;
        int cntr;

        for (int i = 0; i < str.length() - 1; i++) {
            c = str.charAt(++i);
            cntr = 0;

            for (i += (c == '0' ? 2 : 1); i < str.length(); i++) {
                if (str.charAt(i) == '0') cntr++;
                else break;
            }

            binary.append((c == '0' ? "0" : "1").repeat(cntr));
        }

        for (String s : binary.toString().split("(?<=\\G.{7})")) {
            builder.append((char) Integer.parseInt(s, 2));
        }

        return builder;
    }

    private static StringBuilder encode(String binary) {
        StringBuilder builder = new StringBuilder();
        char c;
        int cntr;

        for (int i = 0; i < binary.length(); i++) {
            c = binary.charAt(i);
            cntr = 0;

            for (int j = i + 1; j < binary.length(); j++) {
                if (binary.charAt(j) == c) cntr++;
                else break;
            }

            builder.append(c == '1' ? "0 " : "00 ").append("0%s ".formatted("0".repeat(cntr)));

            i += cntr;
        }

        return builder;
    }

    private static String toBinary(String line) {
        StringBuilder binary = new StringBuilder();

        for (char c : line.toCharArray()) {
            binary.append(String.format("%07d", Integer.parseInt(Integer.toBinaryString(c))));
        }

        return binary.toString();
    }
}