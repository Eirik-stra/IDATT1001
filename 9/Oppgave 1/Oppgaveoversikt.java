package com.SteiraEirik;

import java.util.LinkedList;
import java.util.List;

public class Oppgaveoversikt {
    private List<Student> studenter;
    private int antallStud;


    public Oppgaveoversikt(List<Student> studenter) {
        if (studenter.isEmpty()) {
            this.studenter = new LinkedList<>();
        }
        this.studenter = new LinkedList<>(studenter);
        antallStud=studenter.size();
    }

    public Oppgaveoversikt() {
        this.studenter =  new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.studenter.size());
        for (Student i : this.studenter) {
            str.append(i.getNavn() + ", " + i.getAntOppg() + "\n");
        }
        return str.toString();
    }

    public List<Student> getStudenter() {
        return studenter;
    }

    // Finn antall studenter registrert
    public int finnAntallStudReg() {
        return this.studenter.size();
    }

    // Finn antall oppgaver som en bestemt student har løst
    public int finnOppgLøst(Student stud) {
        if (stud == null) {
            return -1;
        }

        int pos = finnStudent(stud.getNavn());
        return this.studenter.get(pos).getAntOppg();
    }

    // Finn en bestemt student
    public int finnStudent(Student stud) {
        return this.studenter.indexOf(stud);
    }

    private int finnStudent(String navn) {
        for(int i=0; i<this.studenter.size(); i++) {
            Student student = this.studenter.get(i);
            if(student.getNavn().equals(navn)) {
                return i;
            }
        }
        return -1;
    }

    public Student queryStudent(String navn) {
        int pos = finnStudent(navn);
        if(pos >= 0) {
            return this.studenter.get(pos);
        }

        return null;
    }


    // Registrer en ny student
    public boolean registrerNyStudent(Student s) {
        if (s == null) {
            return false;
        }
        return this.studenter.add(s);
    }

    //  Øk antall oppgaver for en bestemt student.
    public boolean økAntallOppgaver(Student s, int antall) {
        if (s == null || antall < 0) {
            return false;
        }
        this.studenter.get(finnStudent(s)).økAntallOppg(antall);
        return true;
    }

    public boolean økAntallOppgaver(String navn, int antall) {
        Student s = queryStudent(navn);
        return økAntallOppgaver(s, antall);
    }
}
