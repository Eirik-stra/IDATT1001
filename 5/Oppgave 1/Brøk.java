package com.SteiraEirik;

import java.util.*;

/*
TO-DO:
    - forkort brøkene
    - testklient
 */

public class Brøk {
    private int teller;
    private int nevner;

    public Brøk(int teller, int nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException("Sorry bro");
        }

        this.teller = teller;
        this.nevner = nevner;
    }

    public Brøk(int teller) {
        this(teller, 1);
    }

    // updates the instance of which is calling this method
    // returns LinkedList[n, m], n=nevner, m=teller
    private List<Integer> finnFellesnevner(Brøk obj) {
        List<Integer> lst = new LinkedList<>();
        boolean found = false;
        int n=0;
        int m=0;

        while(!found) {
            m++;
            while (!found) {
                n++;
                if (this.nevner * n == obj.getNevner() * m) {
                    this.nevner *= n;
                    this.teller *= n;
                    found = true;
                }
            }
        }

        lst.add(n);
        lst.add(m);
        return lst;
    }

    public void summer(Brøk brøk) {
        // må ha lik nevner
        // oppdatere brøken eller returnere en ny variabel?

        if (this.nevner == brøk.getNevner()) {
            this.teller += brøk.getTeller();
        } else {
            // finner fellesnevnere og summerer tellerne
            List<Integer> fellesnevnere = finnFellesnevner(brøk);
            int n = fellesnevnere.get(0);
            int m = fellesnevnere.get(1);
            this.teller += (brøk.getTeller() * m);
        }
    }

    public void subtraher(Brøk brøk) {
        // må ha lik nevner
        if (this.nevner == brøk.getNevner()) {
            this.teller -= brøk.getTeller();
        } else {
            // finn fellesnevner og trekk fra tellerne
            // DRY?
            List<Integer> fellesnevnere = finnFellesnevner(brøk);
            int n = fellesnevnere.get(0);
            int m = fellesnevnere.get(1);
            this.teller -= (brøk.getTeller() * m);
        }
    }

    public void multipliser(Brøk brøk) {
        this.teller *= brøk.getTeller();
        this.nevner *= brøk.getNevner();
    }

    public void divider(Brøk brøk) {
        this.teller *= brøk.getNevner();
        this.nevner *= brøk.getTeller();

        brøk.forkort();
        this.forkort();
    }

    public boolean forkort() {
        boolean found = false;
        int m=2;

        while(!found) {
            if (this.nevner % m == 0 && this.teller % m == 0) {
                // hvordan få den til å finne største delelige
                System.out.println(m);
                found = true;
            }
            m++;
        }

        this.teller =(this.getTeller() / m);
        this.nevner = (this.getNevner() / m);
        return found;
    }
    // getters
    public int getTeller() {
        return teller;
    }

    public int getNevner() {
        return nevner;
    }

    @Override
    public String toString() {
        return teller + "/" + nevner;
    }
}
