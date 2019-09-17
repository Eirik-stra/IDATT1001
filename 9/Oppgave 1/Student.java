package com.SteiraEirik;

public class Student implements Comparable<Student>{
    private String navn;
    private int antOppg;

    public Student(String navn) {
        this.navn = navn; // formater navn?
        this.antOppg = 0;
    }

    public void økAntallOppg(int økning) {
        this.antOppg += økning;
    }

    @Override
    public String toString() {
        return this.navn + ", oppgaver bestått: " + this.antOppg;
    }

    // sorteres i alfabetisk rekkefølge etter fornavn
    @Override
    public int compareTo(Student s) {
        if (s.getNavn() == this.getNavn()) {
            return 0;
        } else if(this.getNavn().toLowerCase().charAt(0) > s.getNavn().toLowerCase().charAt(0)) {
            return 1;
        }
        return -1;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }
}
