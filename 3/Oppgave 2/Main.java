package com.SteiraEirik;

import java.util.Scanner;

public class Main {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        boolean play = true;
        System.out.println("Type '-1' to exit.");

        while (play) {
            System.out.println("Enter a number: ");
            int num = s.nextInt();

            if (num == -1) {
                play = false;
            } else if (num < -1) {
                System.out.println("Invalid number");

            } else if (checkIfPrimeNum(num)) {
                System.out.println(num + " is prime");
            } else {
                System.out.println(num + " is not prime");
            }
        }
    }

    private static boolean checkIfPrimeNum(int num) {
        // kan bare deles med seg selv og 1
        // ingen rest

        // kvadratrot av num
        int m = num/2;

        if (num == 0 || num == 1) {
            return false;
        } else {
            for (int i = 2; i <= m; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
