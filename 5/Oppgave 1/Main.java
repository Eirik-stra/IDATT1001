package com.SteiraEirik;

public class Main {

    public static void main(String[] args) {

        // alle resultater lagres i Brøk brøk
        Brøk brøk = new Brøk(2, 2);
        Brøk brøk2 = new Brøk(2, 6);

        System.out.println(brøk.toString());
        System.out.println("+");
        System.out.println(brøk2.toString());

        brøk.summer(brøk2); // 4/6

        System.out.println("=");
        System.out.println(brøk);

        System.out.println("-------------");
        System.out.println("Multiplikasjon: ");
        System.out.println("brøk1: " + brøk.getTeller() + "/" + brøk.getNevner());
        System.out.println("brøk1: " + brøk2.getTeller() + "/" + brøk2.getNevner());
        brøk.multipliser(brøk2);
        System.out.println("=" + brøk); // 4/6 * 2/6 = 8/36

        System.out.println("-------------");
        System.out.println("Divisjon: ");
        System.out.println("brøk1: " + brøk.getTeller() + "/" + brøk.getNevner());
        System.out.println("brøk1: " + brøk2.getTeller() + "/" + brøk2.getNevner());
        brøk.divider(brøk2);
        System.out.println("=" + brøk);

    }
}
