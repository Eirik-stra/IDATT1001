package com.SteiraEirik;

public class Kjøttdeig {
    private String name;
    private double price;
    private double weight;

    public Kjøttdeig(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight / 1000; // converted to kg
    }

    // returns 1 if object being compared to another is more expensive
    // returns 0 if cheaper
    public int compareTo(Kjøttdeig o) {
        if (o == null || this == o) {
            return -1;
        }

        if (this.calcKgPrice() > o.calcKgPrice()) {
            return 1;
        }

        return 0;
    }

    public double calcKgPrice() {
        double weightInKg = this.weight;
        double kgPrice = price / weightInKg;
        return kgPrice;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
