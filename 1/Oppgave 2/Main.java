package com.SteiraEirik;

public class Main {

    public static void main(String[] args) {
        System.out.println(convertTime(1, 1, 1));
        System.out.println(convertTime(0));
    }

    private static int convertTime(int hours, int minutes, int seconds) {
        return (hours * 3600) + (minutes * 60) + seconds;
    }

    // Extra
    private static int convertTime(int minutes, int seconds) {
        return convertTime(0, minutes, seconds);
    }

    private static int convertTime(int seconds) {
        return seconds;
    }
}