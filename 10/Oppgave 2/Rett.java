package com.SteiraEirik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rett {
    private final String navn; // identifier - final på alle - sparer tid og minne og ser bra yt
    private String type;
    private double pris;
    private String oppskrift;
    public static final List<String> TYPE;

    static {
        String[] typer = {"forrett", "hovedrett", "dessert"};
        TYPE = new ArrayList<>(Arrays.asList(typer));
    }

    public Rett(String navn, String type, double pris, String oppskrift) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.oppskrift = oppskrift;
    }

    public String getNavn() {
        return navn;
    }

    public String getType() {
        return type;
    }

    public double getPris() {
        return pris;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        return "navn='" + navn + '\'' +
                ", type='" + type + '\'' +
                ", pris=" + pris +
                ", oppskrift='" + oppskrift +
                "',\n";
    }
}
