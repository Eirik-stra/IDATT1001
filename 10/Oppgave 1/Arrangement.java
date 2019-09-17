package com.SteiraEirik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrangement implements Comparable<Arrangement> {
    public static int antall=0;
    public int nummer=0;
    private String navn;
    private String sted;
    private String arrangør;
    private String type;
    public static final List<String> TYPE;
    private long tidspunkt;

    static {
        String[] typeArr = {"festival", "konsert", "barneteater", "foredrag", "kurs"};
        TYPE = new ArrayList<>(Arrays.asList(typeArr));
    }

    public Arrangement(String navn, String sted, String arrangør, String type, long tidspunkt) {
        this.nummer = this.antall;
        this.antall++;

        this.navn = navn;
        this.sted = sted;
        this.arrangør = arrangør;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    @Override
    public String toString() {
        return "nummer=: " + nummer +
                ", navn='" + navn + '\'' +
                ", sted='" + sted + '\'' +
                ", arrangør='" + arrangør + '\'' +
                ", type='" + type + '\'' +
                ", tidspunkt=" + tidspunkt;
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public String getArrangør() {
        return arrangør;
    }

    public String getSted() {
        return sted;
    }

    public long getTidspunkt() {
        return tidspunkt;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(Arrangement o) {
        return Long.compare(this.tidspunkt, o.getTidspunkt());
    }
}
