package com.steiraEirik;

public class Oppg3 {
    public static void main(String[] args) {
        Temperaturer temp = new Temperaturer();
        System.out.println(temp.toString());
        System.out.println("--------------");
        System.out.println("Middeltemperatur hver dag: " + temp.getMiddelTempHverDag());
        System.out.println("Middeltemperatur per time: " + temp.getMiddeltempForHverTime());
        System.out.println("Middeltemperatur for hele måneden: " + temp.getMiddeltempMnd());

        for (int i=0; i<temp.getGrupperinger().length; i++) {
            switch (i) {
                case 0:
                    System.out.println("Antall døgn med middeltemp. mindre enn -5 grader: " + temp.getGrupperinger()[0]);
                    break;
                case 1:
                    System.out.println("Antall døgn med middeltemp. mellom -5 og 0 grader: " + temp.getGrupperinger()[1]);
                    break;
                case 2:
                    System.out.println("Antall døgn med middeltemp. mellom 0 og 5 grader: " + temp.getGrupperinger()[2]);
                    break;
                case 3:
                    System.out.println("Antall døgn med middeltemp. mellom 5 og 10 grader: " + temp.getGrupperinger()[3]);
                    break;
                case 4:
                    System.out.println("Antall døgn med middeltemp. over 10 grader: " + temp.getGrupperinger()[4]);
                    break;
                default:
                    System.out.println("Ingen dager oppfyller kravene.");
            }
        }

    }
}

//    d) Antall døgn med middeltemperatur innen følgende grupper: mindre enn -5 grader,
//    mellom -5 og 0, mellom 0 og 5, mellom 5 og 10 og 10 og over 10 grader.
