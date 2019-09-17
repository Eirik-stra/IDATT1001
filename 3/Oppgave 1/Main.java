package com.SteiraEirik;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        int startNum = 0;
        int endNum = 0;

        try {
            System.out.println("Enter a number: ");
            startNum = s.nextInt();

            System.out.println("Enter another number: ");
            endNum = s.nextInt();

            printTable(startNum, endNum);
        } catch(InputMismatchException e) {
            System.out.println("That is not a number.");
        }
    }

    private static void printTable(int startNum, int endNum) {
        int i = 1;

        while(i <= 10 && startNum <= endNum) {
            if (i == 1) {
                System.out.println(startNum + "-gangen:");
            }
            if (startNum == endNum + 1) {
                break;
            }

            System.out.println(startNum + " x " + i + " = " + startNum * i);
            i++;

            if (i == 11) {
                startNum++;
                i = 1;
                System.out.println();
            }
        }
    }

}
