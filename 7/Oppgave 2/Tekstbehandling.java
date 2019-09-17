package com.SteiraEirik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tekstbehandling {
    private final String TEKST;

    public Tekstbehandling(String tekst) {
        this.TEKST = tekst;
    }

    // • Å hente ut teksten slik den står, uten endringer.
    public String getTEKST() {
        return TEKST;
    }

    // • Å hente ut teksten, men slik at alle bokstaver er store.
    public String getTEKSTStore() {
        return this.getTEKST().toUpperCase();
    }

    // • Å finne antall ord i teksten.
    public int finnAntallOrd() {
        String[] tekst = this.getTEKST().split("[\\s@&.,!?$+-]+"); //alt unntatt symboler
        return tekst.length;
    }

    // • Å finne gjennomsnittlig ordlengde.
    public int finnGjOrdLengde() {
        String[] tekst = this.getTEKST().split("[\\s@&.,!?$+-]+");
        int gjSnitt = 0;

        for (String i : tekst) {
            gjSnitt += i.length();
        }

        return gjSnitt / tekst.length;
    }

    /*
    Å finne gjennomsnittlig antall ord per periode. Bruk punktum, utropstegn,
        kolon og spørretegn som skilletegn mellom periodene.
        Anta at teksten er feilfri, slik at ikke to eller flere slike tegn følger etter hverandre.
     */
    // simple is always better
    public int finnGjAntallOrdPrPeriode() {
        List<List<String>> lst = new ArrayList<>();
        String[] tekst = (this.getTEKST().split("[.:!?-]+"));

        for (int i=0; i<tekst.length; i++) {
            lst.add(Arrays.asList(tekst[i]));
        }

        int gjSnitt = 0;
        int antallOrd = 0;

        // liker ikke dette men det funker
        String[] temp = null;
        for (int i= 0; i <lst.size(); i++) {
            for (String j : lst.get(i)) {
                temp = j.split("[\\s@&.,!?$+-]+");
                for (String k : temp) {
                    if (k.isBlank()) {
                        continue;
                    }
                    gjSnitt += k.length();
                    antallOrd++;
                }
            }
        }

        return gjSnitt / antallOrd;
    }

    /*

    • Å skifte ut et ord med et annet gjennom hele teksten.
        For eksempel kan en ønske å skifte ut ordet «finnes» med «fins».
     */
    public String byttUtOrd(String originalOrd, String annetOrd) {
        String[] tekstArr = this.TEKST.split("[\\s@&.,!?$+-]+");

        for (int i=0; i<tekstArr.length; i++) {
            if (tekstArr[i].equalsIgnoreCase(originalOrd)) {
                tekstArr[i] = annetOrd;
            }
        }
        return String.join(" ", tekstArr);
    }
}
