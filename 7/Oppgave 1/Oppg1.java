package com.SteiraEirik;

public class Oppg1 {

    private static String testStr = "denne setningen kan forkortes";
    private static NyString s = new NyString(testStr);

    public static void main(String[] args) {

        System.out.println(s.forkort());
        System.out.println(s.fjernTegn("n"));// dnn stningn kan forkorts
    }
}
