package com.SteiraEirik;

public class Main {

    public static void main(String[] args) {
        System.out.println(convert(1.0));
    }

    private static double convert(double inches) {
        return inches * 2.54;
    }
}
