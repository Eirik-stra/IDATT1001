package com.SteiraEirik;

import java.util.ArrayList;
import java.util.Arrays;

public class Oppg2 {

    private static Rett r1 = new Rett("Carpaccio", "forrett", 20, "Lorem Ipsum");
    private static Rett r2 = new Rett("kjøttboller", "hovedrett", 20, "Lorem Ipsum");
    private static Meny m1 = new Meny(new ArrayList<>(Arrays.asList(r1, r2)));

    private static Rett r3 = new Rett("pasta arriabata", "hovedrett", 10, "Lorem Ipsum");
    private static Rett r4 = new Rett("vaniljeis", "dessert", 10, "Lorem Ipsum");
    private static Meny m2 = new Meny(new ArrayList<>(Arrays.asList(r3, r4)));

    private static MenyRegister reg1 = new MenyRegister(new ArrayList<>(Arrays.asList(m1, m2)));

    private static Rett r5 = new Rett("lasagne", "hovedrett", 50, "Lorem Ipsum");
    private static Rett r6 = new Rett("sjokoladeis", "dessert", 50, "Lorem Ipsum");
    private static ArrayList<Rett> m3 = new ArrayList<>(new ArrayList<>(Arrays.asList(r5, r6)));


    public static void main(String[] args) {
        System.out.println(reg1);

        String testRettStr= "Carpaccio";
        String testRettType = "hovedrett";
        double minTest = 10;
        double maxTest = 50;


        System.out.println("Søkte etter '" + testRettStr + "', fant: " + reg1.finnRett(testRettStr));
        System.out.println("Søkte etter '" + testRettType + "', fant: " +  reg1.finnRetter(testRettType));
        System.out.println();
        System.out.println("Søkte etter totalpris i intervallet '" + minTest + "-" + maxTest +  "', fant: " +  reg1.finnMeny(minTest, maxTest));
        System.out.println();
        System.out.println("Prøver å registrere ny rett: " + reg1.registrerRett("Tomatsuppe", "hovedrett", 40, "Lorem Ipsum"));
        System.out.println("Prøver å registrere ny meny: " + reg1.registrerMeny(m3));
    }
}
