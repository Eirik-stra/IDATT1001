package com.SteiraEirik;

public class Oppg3 {
    private static int[][] matrise1 = {{2, 1}, {1, 1}};
    private static int[][] matrise2 = {{2, 1}, {1, 1}};
    private static Matrise m1 = new Matrise(matrise1);
    private static Matrise m2 = new Matrise(matrise2);

    public static void main(String[] args) {

        System.out.println(m1);
        System.out.println(m2);
//        System.out.println(m1.adder(m2).toString());
        System.out.println(m1.multipliser(m2).toString());
    }
}


