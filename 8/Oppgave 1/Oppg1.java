package com.SteiraEirik;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Oppg1 {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    public static ArbTaker leggTilNyAnsatt() {

        System.out.println("Legg til en ny ansatt.");
        ArbTaker arbTaker = null;

        try{
            // lag nytt person-objekt
            System.out.println("Fornavn: ");
            String fornavn = s.nextLine().trim();

            System.out.println("Etternavn: ");
            String etternavn = s.nextLine().trim();

            System.out.println("Fødselsår: ");
            int fødselsår = s.nextInt();

            Person person = new Person(fornavn, etternavn, fødselsår);

            // lag et nytt ArbTaker objekt
            System.out.println("Arbeidstakernummer: ");
            int arbTakerNr = s.nextInt();

            System.out.println("Ansettelsesår: ");
            int ansettelsesÅr = s.nextInt();

            System.out.println("Månedslønn: ");
            double månedsLønn = s.nextInt();  // la brukeren skrive inn heltall

            System.out.println("Skatteprosent: ");
            double skatteprosent = s.nextInt();

            arbTaker = new ArbTaker(person, arbTakerNr, ansettelsesÅr, månedsLønn, skatteprosent);
        } catch(InputMismatchException e) {
            System.out.println("Noe gikk galt");
        }

        return arbTaker;
    }


    private static boolean start(){
        boolean ferdig = false;


        ArbTaker a = leggTilNyAnsatt();
        if (a == null) {
            return false;
        }
        System.out.println(a);

        while (!ferdig) {

            try {
                printMenu();
                int valg = s.nextInt();

                switch (valg) {
                    case 0:
                        ferdig = true;
                        break;
                    case 1:
                        System.out.println("Nytt arbeidstakernummer: ");
                        int nyttNr = s.nextInt();
                        a.setArbTakerNr(nyttNr);
                        System.out.println("Arbeidstakernummer ble endret.");
                        break;
                    case 2:
                        System.out.println("Nytt ansettelsesår: ");
                        int nyttÅr = s.nextInt();
                        a.setAnsettelsesÅr(nyttÅr);
                        System.out.println("Ansettelsesår ble endret.");
                        break;
                    case 3:
                        System.out.println("Ny månedslønn: ");
                        int nyLønn = s.nextInt();
                        a.setMånedsLønn(nyLønn);
                        System.out.println("Månedslønn ble endret.");
                        break;
                    case 4:
                        System.out.println("Ny skatteprosent: ");
                        int nyProsent = s.nextInt();
                        System.out.println("Skatteprosent ble endret.");
                        break;
                    case 5:
                        printAnsattData(a);
                        break;
                    case 6:
                        System.out.println("Oppgi antall år som ønskes testet: ");
                        int år = s.nextInt();
                        System.out.println("Personen har vært ansatt i mer enn " + år + " år: " +
                                (a.harVærtAnsattLengreEnn(år) ? "Ja" : "Nei") + "\n"
                        );
                        break;
                    default:
                        System.out.println("Ikke et gyldig valg.");
                        printMenu();
                }

            } catch (InputMismatchException e) {
                System.out.println("Ugyldig valg. Prøv på nytt.");
                printMenu();
                continue;
            }

            System.out.println(a);
        }
        return true;
    }

    public static void printMenu() {
        System.out.println(
                "Endre en anstattprofil: " + "\n"  +
                        "0 - Avslutt " + "\n" +
                        "1 - Endre arbeidstakernummer: " + "\n" +
                        "2 - Endre ansettelsesår: " +"\n" +
                        "3 - Endre månedslønn: " + "\n" +
                        "4 - Endre skatteprosent: " + "\n" +
                        "5 - Vis ansattdataene" + "\n" +
                        "6 - Sjekk om ansatte har vært ansatt i mer enn x år"
        );
    }

    public static void printAnsattData(ArbTaker a) {
        System.out.println("Månedlig skattetrekk: " + a.månedligSkatteTrekk() + "kr");
        System.out.println("Bruttolønn per år: " + a.bruttolønn() + "kr");
        System.out.println("Skattetrekk per år: " + a.årligSkatteTrekk() + "kr");
        System.out.println("Ansattes navn: " + a.getNavn());
        System.out.println("Ansattes alder: " + a.alder() + " år");
        System.out.println("Antall år ansatt i bedriften: " + a.årAnstatt() + " år");
        System.out.println();
    }


}
