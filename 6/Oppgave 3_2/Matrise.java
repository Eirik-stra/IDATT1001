package com.SteiraEirik;

/*
    • Addere en matrise til denne matrisen
    • Multiplisere denne matrisen med en annen matrise
    • Transponere matrisen.

    - alle metodene må returnere nye objekter hvis mulig, ellers null
 */
public final class Matrise {
    private final int[][] matrise;

    public Matrise(int[][] matrise) {
        this.matrise = matrise;
    }

    public int[][] getMatrise() {
        return matrise;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (int i=0; i<this.matrise.length; i++) {
            str.append("\t\t");
            for(int j=0; j<this.matrise[i].length; j++) {
                String newStr = "[" + this.matrise[i][j] + "]";
                str.append(newStr);
            }
            str.append("\n");
        }
        return "Matrise{\n" +
                "\tmatrise=\n" + str +
                "}";
    }

    public Matrise adder(Matrise matrise) {
        if (!(this.matrise.length == matrise.getMatrise().length)) {
            return null;
        }

        int rader = this.matrise.length;
        int kolonner = this.matrise[0].length;
        int[][] sumMatrise = new int[rader][kolonner];

        for (int i=0; i<this.matrise.length; i++) {
            if (!(this.matrise[i].length == matrise.getMatrise()[i].length)) {
                return null;
            }

            for (int j=0; j<this.matrise.length; j++) {
                sumMatrise[i][j] = this.matrise[i][j] + matrise.getMatrise()[i][j];
            }
        }
        return new Matrise(sumMatrise);
    }

    public Matrise multipliser(Matrise matrise) {
        // finn innersida - m rader, n kolonner

        // m1 != n2
        if (!(this.matrise.length == matrise.getMatrise()[0].length)) {
            return null;
        }

        int matrise1Rader = this.matrise.length;
        int matrise2Kol = matrise.getMatrise()[0].length;
        int matrise2Rader = matrise.getMatrise().length;

        int[][] prodMatrise = new int[matrise1Rader][matrise2Kol];

        int sum = 0;
        for (int c = 0; c < matrise1Rader; c++)
        {
            for (int d = 0; d < matrise2Kol; d++)
            {
                for (int k = 0; k < matrise2Rader; k++)
                {
                    sum = sum + this.matrise[c][k]*matrise.getMatrise()[k][d];
                }

                prodMatrise[c][d] = sum;
                sum = 0;
            }
        }

        return new Matrise(prodMatrise);
    }
}
