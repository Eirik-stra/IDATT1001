package com.SteiraEirik;

public class Valuta {

    private double kurs; // 1 {valutanavn} to NOK
    private String navn;

    public Valuta(double kurs, String navn) {
        this.kurs = kurs;
        this.navn = navn;
    }

    public double convertToNOK(double amount) {
        // gang valuta med norsk kurs
        return amount * this.kurs;
    }

    public double convertFromNOK(double amount) {
        // gang nok med valuta
        return amount / this.kurs;
    }

    public String getnavn() {
        return navn;
    }
}
