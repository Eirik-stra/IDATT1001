package com.SteiraEirik;

public class Oppg2 {
    private static Tekstbehandling t = new Tekstbehandling("Dennå setningen er min!");
    private static Tekstbehandling r = new Tekstbehandling("min- min, min");
    private static Tekstbehandling s = new Tekstbehandling("dou kje, jeg err. een? kkj! opk");


    public static void main(String[] args) {
        System.out.println("Antall ord i t: " + t.finnAntallOrd());
        System.out.println("Gj. lengde på ordene i r: " + r.finnGjOrdLengde());
        System.out.println("Gj. antall ord per periode i s: " + s.finnGjAntallOrdPrPeriode());
        System.out.println(t.getTEKST() + " ---> " + t.byttUtOrd("min", "din"));
        System.out.println(t.getTEKST());
        System.out.println(t.getTEKSTStore());
    }
}
