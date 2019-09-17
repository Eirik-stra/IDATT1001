package com.SteiraEirik;

public class Main {

    // regn ut kilopris
    // sammenlign 2 priser

    public static void main(String[] args) {
        Kjøttdeig typeA = new Kjøttdeig("type A", 35.90, 450);
        Kjøttdeig typeB = new Kjøttdeig(    "type B", 39.50, 500);

        if (typeA.compareTo(typeB) == 1) {
            System.out.println(
                    typeA.getName() + " costs " + String.format("%.2f", typeA.calcKgPrice()) + " per/kg and is more expensive than "
                    + typeB.getName() + " which costs " + String.format("%.2f", typeB.calcKgPrice()) + " per/kg."
            );
        } else if (typeA.compareTo(typeB) == 0) {
            System.out.println(
                    typeB.getName() + " costs " + String.format("%.2f", typeB.calcKgPrice()) + " per/kgand is more expensive than "
                            + typeA.getName() + " which costs " + String.format("%.2f", typeA.calcKgPrice()) + " per/kg"
            );
        } else {
            System.out.println("They cost the same");
        }

    }

}
