package com.SteiraEirik;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Spiller spiller1 = new Spiller();
        Spiller spiller2 = new Spiller();
        spiller1.setSumPoeng(90); // for testing
        startGame(spiller1, spiller2);
    }

    private static void startGame(Spiller spiller1, Spiller spiller2) {
        boolean ferdig = false;

        while(!ferdig) {
            System.out.println("Tast 0 for å avslutte.");

            // Be spillerne om å kaste terningen
            int spiller1Input = 0;
            int spiller2Input = 0;

            try {
                System.out.println("Spiller 1: Tast '1' for å kaste terningen");
                spiller1Input = s.nextInt();

                System.out.println("Spiller 2: Tast '1' for å kaste terningen");
                spiller2Input = s.nextInt();
            } catch(InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Ugyldig valg");
            }

            // Sjekk om en spiller avbrøt spillet
            if (spiller1Input == 0 || spiller2Input == 0) {
                System.out.println("En spiller avsluttet spillet");
                ferdig = true;
            }

            // kast terningene
            int spiller1TerningKast = spiller1.kastTerningen();
            int spiller2TerningKast = spiller2.kastTerningen();

            // Print resultatet
            System.out.println("Spiller 1 kastet " + spiller1TerningKast + "\n " +
                    "Sum spiller 1: " + spiller1.getSumPoeng());
            System.out.println("Spiller 2 kastet " + spiller2TerningKast + "\n " +
                    "Sum spiller 2: " + spiller2.getSumPoeng() + "\n");

            // Sjekk om en spiller har vunnet og evt avslutt spillet
            if (spiller1.erFerdig() || spiller2.erFerdig()) {
                if (spiller1.erFerdig()) {
                    System.out.println("Spiller 1 har vunnet!");
                } else {
                    System.out.println("Spiller 2 har vunnet!");
                }
                ferdig = true;
            }
        }
    }
}
