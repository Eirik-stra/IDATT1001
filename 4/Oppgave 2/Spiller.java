package com.SteiraEirik;

import java.util.Random;

public class Spiller {
    private int sumPoeng;
    private Random terning;

    public Spiller() {
        this.sumPoeng = 0;
        this.terning = new Random();
    }

    public int getSumPoeng() {
        return sumPoeng;
    }

    public Random getTerning() {
        return terning;
    }

    public void setSumPoeng(int sumPoeng) {
        this.sumPoeng = sumPoeng;
    }

    public int kastTerningen() {
        int terningKast = getTerning().nextInt(6) + 1;
        if (getSumPoeng() > 100) {
            setSumPoeng(getSumPoeng() - terningKast);
        } else {
            setSumPoeng(getSumPoeng() + terningKast);
        }
        return terningKast;
    }

    public boolean erFerdig() {
        return getSumPoeng() == 100;
    }
}
