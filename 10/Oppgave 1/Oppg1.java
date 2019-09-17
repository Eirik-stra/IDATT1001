package com.SteiraEirik;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Oppg1 {

    static Scanner s = new Scanner(System.in);

    // funket ikke å skrive tidspunktet som long
    public static Arrangement a1 = new Arrangement(
            "Findings", "Kristiansand","Eirik", Arrangement.TYPE.get(0), Long.parseLong("201907101400")
    );
    public static Arrangement a2 = new Arrangement(
            "Kadetten", "Sandvika","Steira", Arrangement.TYPE.get(0), Long.parseLong("201908101400")
    );
    public static Arrangement a3 = new Arrangement(
             "Øya", "Oslo","OG productions", Arrangement.TYPE.get(0), Long.parseLong("201908141400")
    );
    public static Arrangement a4 = new Arrangement(
             "Karpe", "Bergen","Karpe prod", Arrangement.TYPE.get(1), Long.parseLong("201909101400")
    );

    public static List<Arrangement> arrangementer = new ArrayList<>();

    public static void main(String[] args) {
        arrangementer.add(a1);
        arrangementer.add(a2);
        arrangementer.add(a3);
        arrangementer.add(a4);

        ArrangementRegister register = new ArrangementRegister(arrangementer);

        System.out.println(register);
        System.out.println(register.registrerArrangement(
                new Arrangement(
                 "Karpe", "Bergen","Karpe prod", Arrangement.TYPE.get(3), Long.parseLong("201909101400")
        )));

        System.out.println(register);
        System.out.println(register.finnArrangement("Oslo"));
        System.out.println(register.finnArrangement(Long.parseLong("201909101400")));

        for (Arrangement a : register.finnArrangement(Long.parseLong("201907101400"), Long.parseLong("201909101400"))) {
            System.out.println(a);
        }

        System.out.println("Etter sted: ");
        for (Arrangement a : register.sorterEtterSted()) {
            System.out.println(a);
        }

        System.out.println("Etter tidspunkt:");
        for (Arrangement a : register.sorterEtterTidspunkt()) {
            System.out.println(a);
        }

        System.out.println("Etter type: ");
        for (Arrangement a : register.sorterEtterType()) {
            System.out.println(a);
        }


        start(register);
    }

    public static void start(ArrangementRegister reg) {
        boolean ferdig = false;

        while(!ferdig) {
            printMenu();
            int valg = 0;
            try {
                valg = s.nextInt();
                s.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("Ugyldig valg");
                ferdig = true;
            }

            switch(valg) {
                case 0:
                    System.out.println("Program avsluttes");
                    ferdig = true;
                    break;
                case 1:
                    System.out.println(reg);
                    break;
                case 2:
                    Arrangement a = registrerArr();
                    reg.registrerArrangement(a);
                    System.out.println("La til " + a);
                    break;
                case 3:
                    System.out.println("Skriv inn sted: ");

                    System.out.println(reg.finnArrangement(s.nextLine()));
                    break;
                case 4:
                    System.out.println("Skriv inn dato på formen 'ÅÅÅÅ-MM-DD-KLKL': ");
                    long tidspunkt = s.nextLong();
                    System.out.println(reg.finnArrangement(tidspunkt));
                    break;
                case 5:
                    System.out.println("Skriv inn tidsintervallet:");
                    long min = s.nextLong();
                    long maks = s.nextLong();
                    System.out.println(reg.finnArrangement(min, maks));
                    break;
                case 6:
                    for (Arrangement ar : reg.sorterEtterSted()) {
                        System.out.println(ar);
                    }
                    break;
                case 7:
                    for (Arrangement ar : reg.sorterEtterType()) {
                        System.out.println(ar);
                    }
                    break;
                case 8:
                    for (Arrangement ar : reg.sorterEtterTidspunkt()) {
                        System.out.println(ar);
                    }
                    break;
                default:
                    System.out.println("Ugyldig valg");
                    continue;

            }
        }
    }

    public static void printMenu() {
        System.out.println(
                "\n" +
                "Meny for arrangementregisteret: \n" +
                        "0 - Avslutt\n" +
                        "1 - Skriv ut registeret\n" +
                        "2 - Registrer et nytt arrangement\n" +
                        "3 - Finn alle arrangementer på et gitt sted\n" +
                        "4 - Finn alle arrangementer på en gitt dato\n" +
                        "5 - Finn alle arrangementer i et gitt intervall\n" +
                        "6 - Sorter etter sted\n" +
                        "7 - Sorter etter type\n" +
                        "8 - Sorter etter tidspunkt\n"
        );
    }


    public static Arrangement registrerArr() {
        try {
            System.out.println("Skriv inn info: ");
            System.out.println("Navn: ");
            String navn = s.nextLine();

            System.out.println("Sted: ");
            String sted = s.nextLine();

            System.out.println("Arrangør: ");
            String arrangør = s.nextLine();

            String type = "";
            boolean gyldigValg = true;
            while (gyldigValg) {
                System.out.println("Velg type fra listen: ");
                for (int i=0; i<Arrangement.TYPE.size(); i++) {
                    System.out.println(i + " - " + Arrangement.TYPE.get(i));
                }

                int valg = s.nextInt();
                System.out.println(valg);
                if (valg > Arrangement.TYPE.size() || valg < 0) {
                    System.out.println("Ugyldig valg.");
                    continue;
                }
                    type = Arrangement.TYPE.get(valg);
                    gyldigValg = true;
                    break;
            }

            System.out.println("Tidspunkt: ");
            long tidspunkt = s.nextLong();
            s.nextLine();

            return new Arrangement(navn, sted, arrangør, type, tidspunkt);
        } catch(InputMismatchException e) {
            System.out.println("Ugyldig valg");
            registrerArr();
        }

        return null;
    }
}
