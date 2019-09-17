package com.SteiraEirik;

import java.util.Scanner;

public class Main {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        while(true) {
            System.out.println("Skriv 'x' for å avslutte");
            System.out.println("Skriv inn en tekst: ");
            String tekst = s.nextLine();

            if(tekst.equals("x")) {
                System.out.println("Avslutter program");
                break;
            }

            TekstAnalyse t = new TekstAnalyse(tekst);
            System.out.println("Antall bokstaver: " + t.finnAntallBokstaver());
            System.out.println("Antall forskjellige bokstaver: " + t.finnAntallForskjelligeBokstaver());
            System.out.println("% av tekst som ikke er bokstaver: " + t.finnProsentAvSymboler());
            System.out.println("Bokstaven/e med flest forekomster er: " + t.finnBokstavMedFlestForekomster());
            System.out.println();
            System.out.println("Skriv inn en bokstav for å finne antall forekomster: ");
            char valgtBokstav = s.nextLine().charAt(0);

            System.out.println("Antall forekomster av '" + valgtBokstav + "': " + t.finnAntallForekomster(valgtBokstav));
        }
    }
}
