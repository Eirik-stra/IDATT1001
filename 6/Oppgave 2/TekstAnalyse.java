package com.SteiraEirik;

public class TekstAnalyse {
    public static final String ALFABET = "abcdefghijklmnopqrstuvwxyzæøå";
    private int[] antallTegn = new int[30];

    public TekstAnalyse(String tekst) {
        finnAntallBokstaverOgTegn(tekst.toLowerCase());
    }

    @Override
    public String toString() {
        String str = "";
        for (int i=0; i<antallTegn.length; i++) {
            str += antallTegn[i] + (i == antallTegn.length-1 ? "" : ",");
        }
        return "[" + str + "]";
    }

    /*
         går gjennom alfabetet for hver bokstav i teksten
         hvis de er like, inkrementer tilsvarende plass i antallTegn
         hvis de ikke er like, inkrementer siste plass i antallTegn
     */
    private void finnAntallBokstaverOgTegn(String tekst) {
        for (int i=0; i<tekst.length(); i++) {
            boolean notALetter = false;

            for(int j=0; j<ALFABET.length(); j++) {
                if(tekst.charAt(i) == ALFABET.charAt(j)) {
                    this.antallTegn[j]++;
                } else if(tekst.charAt(i) < 97 || tekst.charAt(i) > 229) { // a/å
                    notALetter = true;
                }
            }

            if (notALetter) {
                this.antallTegn[antallTegn.length - 1]++;
            }
        }
    }

    public int finnAntallBokstaver() {
        int antall = 0;
        for (int i=0;i<this.antallTegn.length-1;i++) {
            antall += this.antallTegn[i];
        }
        return antall;
    }

    public int finnAntallForskjelligeBokstaver() {
        int antall = 0;
        for (int i=0;i<this.antallTegn.length-1;i++) {
            if (!(this.antallTegn[i] == 0)) {
                antall++;
            }
        }
        return antall;
    }

    // finner andel av tekst som ikke er bokstaver
    public double finnProsentAvSymboler() {
        double total = 0.0;
        double antallSymboler = antallTegn[antallTegn.length-1];

        for (int i=0;i<this.antallTegn.length; i++) {
            total += this.antallTegn[i];
        }

        return Math.round(antallSymboler / total * 100); // nja?
    }

    public int finnAntallForekomster(char bokstav) {
        bokstav = Character.toLowerCase(bokstav);

        for(int i=0; i<ALFABET.length(); i++) {
            if (ALFABET.charAt(i) == bokstav) {
                return this.antallTegn[i];
            }
        }
        return -1;
    }

    public String finnBokstavMedFlestForekomster() {
        int maxAntall = 0;
        StringBuilder str = new StringBuilder("");

        // ccddhhh -> cdh
        for (int i = 0; i < antallTegn.length - 1; i++) {
            // hvis neste bokstav har flere forekomster enn den hittil høyeste
            if(antallTegn[i] > maxAntall) {
                maxAntall = antallTegn[i]; // endre til nye maksverdi
                // hvis det er en bokstav i strengen med lavere forekomster,
                // fjern den og legg til den nye bokstaven
                if (str.length() != 0 ) {
                    str.deleteCharAt(str.length() - 1);
                }
                str.append(ALFABET.charAt(i));
                // hvis nye antall forekomster er lik forrige
                // og strengens lengde ikke er 0,
                // legg til bokstaven i strengen
            } else if(antallTegn[i] == maxAntall && str.length() != 0) {
                str.append(ALFABET.charAt(i));
            }
        }

        return str.toString();
    }

}


