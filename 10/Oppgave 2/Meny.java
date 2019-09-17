package com.SteiraEirik;

import java.util.ArrayList;
import java.util.List;

public class Meny {
    private static int antall=0;
    private int nummer;
    private List<Rett> retter;
    private double totalpris;

    public Meny(List<Rett> retter) {
        if(retter == null) {
            this.retter = new ArrayList<>();
        }
        this.retter = retter;
        this.nummer = antall;
        antall++;

        for (Rett r : retter) {
            if (r != null) {
                this.totalpris += r.getPris();
            }
        }
    }

    public Meny() {
        this(new ArrayList<>());
    }

    @Override
    public String toString() {
        return "Meny " + nummer +
                ", retter=\n" + retter +
                ", totalpris=" + totalpris +
                ",\n";
    }

    public int getNummer() {
        return nummer;
    }

    public List<Rett> getRetter() {
        return retter;
    }

    public double getTotalpris() {
        return totalpris;
    }
}
