package com.SteiraEirik;

import java.util.Random;

// Spør om:
//      - gjøre variablene og metodene static så man slipper å initiere et objekt?

public class MinRandom {
    private Random r;

    public MinRandom() {
        this.r = new Random();
    }

    // gir lavere enn nedre
    public int nesteHeltall(int nedre, int ovre) {
        // bruk r til å generere neste tilfeldige tall
        // transformer resultatet til det ønskede intervallet

        // inkluder maksverdi, + 1, finner omfanget for tallet
        // legg til minsteverdi i intervallet 0-4 -> 0-5  + 10 = 10-15
        // og få innenfor den nedre grensen
        return this.r.nextInt(ovre  + 1 - nedre) + nedre;
    }


    public double nesteDesimaltall(double nedre, double ovre) {
        // bruk r til å generere neste tilfeldige tall
        // transformer resultatet til det ønskede intervallet


        // finn omfanget for tallet
        // og legg til nedre grense for å komme i riktig intervall
        return r.nextDouble() * (ovre - nedre) + nedre;
    }
}
