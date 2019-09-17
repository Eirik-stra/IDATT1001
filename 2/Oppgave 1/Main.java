package com.SteiraEirik;

import java.util.Scanner;

public class Main {

    // delelig med 4
    // unntak 100 --> delelig med 400
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        getInput();
    }

    private static boolean leapYear(int year) {
        if (year == 0) {
            return false;
        }

        boolean isLeapYear = false;

//        if year is 100 it has to be divisible by 400
        if (year % 400 == 0) {
            isLeapYear = true;
        } else if (year % 100 == 0) {
            isLeapYear = false;
        } else if(year % 4 == 0) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }


        return isLeapYear;
    }

    private static void getInput() {
        boolean get = true;
        while (get) {
            System.out.println("Enter a year: ");
            int year = s.nextInt();

            if (year == 0) {
                get = false;
            }

            System.out.println(leapYear(year));
        }
    }
}
