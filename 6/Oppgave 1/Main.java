package com.SteiraEirik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //
        Random random = new Random();
        int[] antall = new int[10];

        for(int i=0; i<=1000; i++) {
            int tall = random.nextInt(10);
            antall[tall]++;
        }

        for (int j=0; j<antall.length; j++) {
            int antallStjerner = Math.round(antall[j] / 10);
            String stjerner = "*".repeat(antallStjerner);
            System.out.println("Antall ganger " + j + " ble generert: " + antall[j] + " " + stjerner);
        }
    }
}
