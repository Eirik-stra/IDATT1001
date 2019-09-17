package com.SteiraEirik;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static Valuta dollar = new Valuta(8.9678, "dollar");
    private static Valuta euro = new Valuta(9.94, "euro");
    private static Valuta SEK = new Valuta(0.9272, "svenske kroner");
    private static Valuta DKK = new Valuta(1.33, "danske kroner");


    public static void main(String[] args) {
	    execute();
    }

    private static void execute(){
        boolean flag = true;

        while (flag) {

            try {

                Valuta selectedValuta = null;

                // step 1
                printMainMenu();
                int choice = s.nextInt();

                switch (choice) {
                    case 1:
                        selectedValuta = dollar;
                        break;
                    case 2:
                        selectedValuta = euro;
                        break;
                    case 3:
                        selectedValuta = SEK;
                        break;
                    case 4:
                        selectedValuta = DKK;
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.out.println("Ikke et gyldig valg.");
                        printMainMenu();
                }

                // step 2
                printConvertChoices();
                int method = s.nextInt();
                if (method == 3) {
                    flag = false;
                }

                // step 3
                printSelectAmount();
                double amount = s.nextDouble();
                if (method == 1) {
                    System.out.println(amount + " " + selectedValuta.getnavn() + " = " + selectedValuta.convertToNOK(amount));
                } else if (method == 2) {
                    System.out.println(amount + " NOK " + " = " + selectedValuta.convertFromNOK(amount));
                }

                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Ugyldig valg. Avslutter programm");
                flag = false;

            }
        }
    }

    private static void printMainMenu() {
        System.out.println(
                "Velg valuta:\n" +
                        "1: dollar\n" +
                        "2: euro\n" +
                        "3: svenske kroner\n" +
                        "4: danske kroner\n" +
                        "5: avslutt"
        );
    }

    private static void printConvertChoices() {
        System.out.println(
                "Du har to valg:\n" +
                        "1: Gjør om til NOK\n" +
                        "2: Gjør om fra NOK\n" +
                        "3: avslutt"
        );
    }

    private static void printSelectAmount() {
        System.out.println("Oppgi mengde: ");
    }

}
