package com.SteiraEirik;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MinRandom r = new MinRandom();

        System.out.println(r.nesteHeltall(50, 55));
        System.out.println(r.nesteDesimaltall(2.0, 2.1));
    }
}
