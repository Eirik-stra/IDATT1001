package com.SteiraEirik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangementRegister implements Comparator<Arrangement>{
        private List<Arrangement> arrangementer;

    public ArrangementRegister(List<Arrangement> arrangementer) {
        this.arrangementer = arrangementer;
    }

    public ArrangementRegister() {
        this(new ArrayList<>());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Arrangement a : this.arrangementer) {
            str.append(a + "\n");
        }
        return str.toString();
    }

    public List<Arrangement> getArrangementer() {
        return arrangementer;
    }

    // Å registrere et nytt arrangement
    public boolean registrerArrangement(Arrangement a) {
        return this.arrangementer.add(a);
    }

    // Å finne alle arrangementer på et gitt sted
    public Arrangement finnArrangement(String sted) {
        for (Arrangement a : this.arrangementer) {
            if (a.getSted().equalsIgnoreCase(sted)) {
                return a;
            }
        }
        return null;
    }

    // Å finne alle arrangementer på en gitt dato
    public List<Arrangement> finnArrangement(long tidspunkt) {
        List<Arrangement> aktuelleArrangementer = new ArrayList<>();
        for (Arrangement a : this.arrangementer) {
            if (a.getTidspunkt() == tidspunkt) {
                aktuelleArrangementer.add(a);
            }
        }
        return aktuelleArrangementer;
    }

    // Å finne alle arrangementer innenfor et tidsintervall gitt ved to datoer. Listen skal være sortert på tid.
    public List<Arrangement> finnArrangement(long tidligsteTidsp, long senesteTidspunkt) {
        List<Arrangement> aktuelleArrangementer = new ArrayList<>();
        for (Arrangement a : this.arrangementer) {
            if (a.getTidspunkt() >= tidligsteTidsp && a.getTidspunkt() <= senesteTidspunkt) {
                aktuelleArrangementer.add(a);
            }
        }

        Collections.sort(aktuelleArrangementer, compareByTidspunkt);
        return aktuelleArrangementer;
    }





    // sorting
    @Override
    public int compare(Arrangement o1, Arrangement o2) {
        return o1.compareTo(o2);
    }

    // HUSK: lag heller egne søkealgoritmer
    Comparator<Arrangement> compareBySted = (Comparator.comparing(Arrangement::getSted));

//    Comparator<Arrangement> compareBySted = (Arrangement o1, Arrangement o2) ->
//            o1.getSted().compareTo( o2.getSted() );

    Comparator<Arrangement> compareByType = (Arrangement o1,Arrangement o2) ->
            o1.getType().compareTo( o2.getType());

//    Comparator<Arrangement> compareByTidspunkt = (Arrangement o1,Arrangement o2) ->
//            o1.getTidspunkt().compareTo( o2.getTidspunkt());

    Comparator<Arrangement> compareByTidspunkt = Comparator.comparingLong(Arrangement::getTidspunkt);





    // Å lage lister over alle arrangementer, sortert etter henholdsvis sted, type og tidspunkt.
    public List<Arrangement> sorterEtterSted() {
        ArrayList<Arrangement> sorted = new ArrayList<>(this.arrangementer);
        Collections.sort(sorted, compareBySted);
        return sorted;
    }

    public List<Arrangement> sorterEtterType() {
        ArrayList<Arrangement> sorted = new ArrayList<>(this.arrangementer);
        Collections.sort(sorted, compareByType);
        return sorted;
    }

    public List<Arrangement> sorterEtterTidspunkt() {
        return this.arrangementer;
    }

}

