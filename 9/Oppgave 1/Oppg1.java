package com.SteiraEirik;

import java.util.LinkedList;
import java.util.List;

public class Oppg1 {

    private static Student eirik = new Student("Eirik Steira");
    private static Student ole = new Student("Ole Tonning Aanderaa");
    private static Student lars = new Student("Lars Østby");
    private static Student simon = new Student("Simon Jensen");
    private static Student mads = new Student("Mads Lundegaard");
    private static List<Student> studenter = new LinkedList<>();


    public static void main(String[] args) {
        System.out.println("Navn: " + eirik.getNavn());
        System.out.println("Oppgaver løst: " + eirik.getAntOppg());
        System.out.println(eirik.toString());
        eirik.økAntallOppg(3);
        System.out.println("Økte antall oppgaver bestått til: " + eirik.getAntOppg());

        studenter.add(eirik);
        studenter.add(ole);
        studenter.add(lars);
        studenter.add(simon);
        studenter.add(mads);

        Oppgaveoversikt studReg = new Oppgaveoversikt(studenter);

        System.out.println();
        System.out.println("Oppgaveoversikt:");
        System.out.println(studReg);
        System.out.println("Antall studenter: " + studReg.finnAntallStudReg());
        System.out.println(eirik.getNavn() + " har bestått: " + studReg.finnOppgLøst(eirik) + " oppgaver");
        System.out.println("Søkte etter 'Simon Jensen': Fant " + studReg.getStudenter().get(studReg.finnStudent(simon)));
        System.out.println("Søkte etter 'Mads Lundegaard': Fant " + studReg.queryStudent("Mads Lundegaard"));

        Student nyStud = new Student("Kari Nordmann");
        System.out.println("Prøver å registrere student, " + nyStud.getNavn() + ": " + studReg.registrerNyStudent(nyStud));
        System.out.println("Øker antall oppgaver bestått for " + eirik.getNavn() + ": " + studReg.økAntallOppgaver(eirik, 10)
                + " - oppgaver bestått: " + eirik.getAntOppg());
        System.out.println("Øker antall oppgaver bestått for " + ole.getNavn() + ": " + studReg.økAntallOppgaver(ole.getNavn(), 8) +
                " - oppgaver bestått: " + ole.getAntOppg());


    }
}
