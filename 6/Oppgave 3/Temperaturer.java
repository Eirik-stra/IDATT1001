package com.steiraEirik;

public class Temperaturer {
    private final int DAYS = 5;
    private final int HOURS = 3;
    private double[][] temperaturer;

    public Temperaturer() {
        this.temperaturer = new double[DAYS][HOURS];

        // fyll tabellen med testverdier
        for (int i=0; i<temperaturer.length; i++) {
            for(int j=0; j<temperaturer[i].length; j++) {
                double temp = j;
                temperaturer[i][j] = temp;
            }
        }
        temperaturer[0][0] = -4.0;
        temperaturer[0][1] = -4.0;
        temperaturer[0][2] = -4.0;

        temperaturer[1][0] = 4.0;
        temperaturer[1][1] = 4.0;
        temperaturer[1][2] = 4.0;

        temperaturer[2][0] = 40.0;
        temperaturer[2][1] = 40.0;
        temperaturer[2][2] = 40.0;


    }

    // Hjelpemetode for å printe en nice tabell
//    private String printTabell() {
//        StringBuilder str = new StringBuilder("");
//        for (int i=0; i<temperaturer.length; i++) {
//            for(int j=0; j<temperaturer[i].length; j++) {
//                str.append("[" + temperaturer[i][j] + "]");
//            }
//            str.append("\n");
//        }
//        return str.toString();
//    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (int i=0; i<temperaturer.length; i++) {
            for(int j=0; j<temperaturer[i].length; j++) {
                String newStr = "[" + temperaturer[i][j] + "]";
                str.append(newStr);
            }
            str.append("\n");
        }

        return "Temperaturer{" +
                "DAYS=" + DAYS +
                ", HOURS=" + HOURS + "\n" +
                ", temperaturer=" + "\n" + str +
                '}';
    }

    private String formaterTabell(double[] tabell) {
        StringBuilder str = new StringBuilder();
        for(double d : tabell) {
            String newStr = "[" + d + "]";
            str.append(newStr);
        }

        return str.toString();
    }

    //       =Gjennomsnittlig temperatur
//    a) Middeltemperaturen for hver dag i måneden

    public String getMiddelTempHverDag() {
        double[] middelTemp = new double[DAYS];

        for(int i=0; i<temperaturer.length; i++) {
            double gjSnitt = 0.0;

            for (int j=0; j<temperaturer[i].length; j++) {
                gjSnitt += temperaturer[i][j];
            }

            gjSnitt = gjSnitt / DAYS;
            middelTemp[i] = gjSnitt;
        }

        return formaterTabell(middelTemp);
    }

    public double[] getMiddelTempHverDagTabell() {
        double[] middelTemp = new double[DAYS];

        for(int i=0; i<temperaturer.length; i++) {
            double gjSnitt = 0.0;

            for (int j=0; j<temperaturer[i].length; j++) {
                gjSnitt += temperaturer[i][j];
            }

            gjSnitt = gjSnitt / DAYS;
            middelTemp[i] = gjSnitt;
        }

        return middelTemp;
    }

//    b) Middeltemperaturen for hver time i døgnet i måneden
    public String getMiddeltempForHverTime() {
        double[] middelTemp = new double[HOURS];

        for(int i=0; i<temperaturer.length; i++) {

            for (int j=0; j<temperaturer[i].length; j++) {
                middelTemp[j] += temperaturer[i][j];
            }

        }

        for(int k=0; k<middelTemp.length; k++) {
            middelTemp[k] /= DAYS;
        }

        return formaterTabell(middelTemp);
    }

//    c) Middeltemperaturen for hele måneden
        public double getMiddeltempMnd() {
            double gjSnitt = 0.0;
            for(int i=0; i<temperaturer.length; i++) {

                for (int j=0; j<temperaturer[i].length; j++) {
                    gjSnitt += temperaturer[i][j];
                }
            }

            return gjSnitt / (DAYS*HOURS);
        }

//    d) Antall døgn med middeltemperatur innen følgende grupper: mindre enn -5 grader,
//    mellom -5 og 0, mellom 0 og 5, mellom 5 og 10 og 10 og over 10 grader.

    // dette ble meget rart
    public int[] getGrupperinger() {
        int[] grupper = {0,0,0,0,0};
        double[] middelTemp = getMiddelTempHverDagTabell();

        for(int i=0; i<middelTemp.length; i++) {
            double temp = middelTemp[i];

           if (temp < -5.0) {
               grupper[0]++;

           } else if (temp > -5.0 && temp < 0.0) {
               grupper[1]++;

           } else if(temp > 0.0 && temp < 5.0) {
               grupper[2]++;

           } else if (temp > 5.0 && temp < 10.0) {
               grupper[3]++;

           } else if (temp > 10.0) {
               grupper[4]++;

           }
        }
        return grupper;
    }
}
