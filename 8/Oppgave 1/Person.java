package com.SteiraEirik;

public final class Person {
    private final String FORNAVN;
    private final String ETTERNAVN;
    private final int FØDSELSÅR;

    public Person(String FORNAVN, String ETTERNAVN, int FØDSELSÅR) {
        this.FORNAVN = FORNAVN.substring(0, 1).toUpperCase() + FORNAVN.substring(1);
        this.ETTERNAVN = ETTERNAVN.substring(0, 1).toUpperCase() + ETTERNAVN.substring(1);
        this.FØDSELSÅR = FØDSELSÅR;
    }

    @Override
    public String toString() {
        return "Fornavn=" + FORNAVN + ",\n" +
                "Etternavn=" + ETTERNAVN + ",\n" +
                "Fødselsår=" + FØDSELSÅR + ",";
    }

    public String getFornavn() {
        return FORNAVN;
    }

    public String getEtternavn() {
        return ETTERNAVN;
    }

    public int getFødselsår() {
        return FØDSELSÅR;
    }

}
