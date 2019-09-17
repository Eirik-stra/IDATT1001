package com.SteiraEirik;

// should methods be protected?
public class ArbTaker {
    private Person person;
    private int arbTakerNr;
    private int ansettelsesÅr;
    private double månedsLønn;
    private double skatteprosent;
    private final int ANTALL_MÅNEDER;

    public ArbTaker(Person person, int arbTakerNr, int ansettelsesÅr, double månedsLønn, double skatteprosent) {
        this.person = person;
        this.arbTakerNr = arbTakerNr;
        this.ansettelsesÅr = ansettelsesÅr;
        this.månedsLønn = månedsLønn;
        this.skatteprosent = skatteprosent;
        this.ANTALL_MÅNEDER = 12;
    }

    public ArbTaker(String fornavn, String etternavn, int fødselsÅr, int arbTakerNr, int ansettelsesÅr, double månedsLønn, double skatteprosent) {
        this(new Person(fornavn, etternavn, fødselsÅr), arbTakerNr, ansettelsesÅr, månedsLønn, skatteprosent);
    }

    @Override
    public String toString() {
        return "ArbTaker:" + "\n" +
                 person + "\n" +
                "arbTakerNr=" + arbTakerNr + ",\n" +
                "ansettelsesÅr=" + ansettelsesÅr + ",\n" +
                "månedsLønn=" + månedsLønn + ",\n" +
                "skatteprosent=" + skatteprosent + "\n";
    }

    // Hvor mange kroner arbeidstakeren trekkes i skatt per måned
    public double månedligSkatteTrekk() {
        return this.månedsLønn * (this.skatteprosent / 100);
    }

    // • Bruttolønn per år;
    public double bruttolønn() {
        return this.månedsLønn * this.ANTALL_MÅNEDER;
    }

    // • Skattetrekk per år.
    //      Husk at juni er skattefri og i desember betales halv skatt;
    public double årligSkatteTrekk() {
        return (this.månedligSkatteTrekk() * 10) + (this.månedligSkatteTrekk() / 2);
    }

    // • Navn på formen: etternavn, fornavn, eksempel: Johnsen, Berit;
    public String getNavn() {
        return this.person.getEtternavn() + ", " + this.person.getFornavn();
    }

    // • Alder;
    public int alder() {
        java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
        int år = kalender.get(java.util.Calendar.YEAR);
        return år - this.person.getFødselsår();
    }

    // • Antall år ansatt i bedriften;
    public int årAnstatt() {
        java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
        int år = kalender.get(java.util.Calendar.YEAR);
        return år - this.ansettelsesÅr;
    }

    // • Om personen har vært ansatt mer enn et gitt antall år (parameter);
    public boolean harVærtAnsattLengreEnn(int antallÅr) {
        return this.årAnstatt() > antallÅr;
    }





    // get-metoder
    public Person getPerson() {
        return person;
    }

    public int getArbTakerNr() {
        return arbTakerNr;
    }

    public int getAnsettelsesÅr() {
        return ansettelsesÅr;
    }

    public double getMånedsLønn() {
        return månedsLønn;
    }

    public double getSkatteprosent() {
        return skatteprosent;
    }

    // set-metoder
    public void setMånedsLønn(double månedsLønn) {
        this.månedsLønn = månedsLønn;
    }

    public void setSkatteprosent(double skatteprosent) {
        this.skatteprosent = skatteprosent;
    }

    public void setArbTakerNr(int arbTakerNr) {
        this.arbTakerNr = arbTakerNr;
    }

    public void setAnsettelsesÅr(int ansettelsesÅr) {
        this.ansettelsesÅr = ansettelsesÅr;
    }
}
