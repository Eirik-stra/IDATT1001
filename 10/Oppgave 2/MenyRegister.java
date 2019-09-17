package com.SteiraEirik;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// menyer er sortert etter nummer
public class MenyRegister implements Comparator<Meny> {
    private List<Meny> menyer;

    public MenyRegister(List<Meny> menyer) {
        this.menyer = menyer;
    }

    public MenyRegister() {
        this(new ArrayList<>());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Menyer: \n");
        for (Meny m : this.menyer) {
            str.append(m + "\n");
        }
        return str.toString();
    }

    @Override
    public int compare(Meny o1, Meny o2) {
        return Integer.compare(o1.getNummer(), o2.getNummer());
    }

    // Registrer ny rett
    public Rett registrerRett(String navn, String type, double pris, String oppskrift) {
        return new Rett(navn, type, pris, oppskrift);
    }

     // Å finne en rett, gitt navnet.
    public Rett finnRett(String navn) {
        Iterator<Meny> menyIterator = this.menyer.iterator();

        while (menyIterator.hasNext()) {
            Meny meny = menyIterator.next();

            for (Rett rett : meny.getRetter()) {
                if (rett.getNavn().equalsIgnoreCase(navn)) {
                    return rett;
                }
            }
        }
        return null;

        // for (int i=0; i<this.menyer.size(); i++) {
        //      for (int j=0; j< this.menyer.get(i); j++) {
        //          if (this.menyer.get(i).get(j).getNavn().equalsIgnoreCase(navn) {
        //              return this.menyer.get(i).get(j);
        //          }
        //      }
        // }
    }

    // Å finne alle retter av en gitt type.
    public List<Rett> finnRetter(String type) {
        Iterator<Meny> menyIterator = this.menyer.iterator();
        List<String> typer = Rett.TYPE;
        List<Rett> retterFunnet = new ArrayList<>();

        while (menyIterator.hasNext()) {
            Meny meny = menyIterator.next();

            for (Rett rett : meny.getRetter()) {
                if (typer.contains(type)) {
                    if (rett.getType().equalsIgnoreCase(type)) {
                        retterFunnet.add(rett);
                    }
                }
            }
        }
        return retterFunnet;
    }

    /*
        Å registrere en ny meny som består av ett sett med retter. - sett?
     */
    public boolean registrerMeny(List<Rett> nyMeny) {
        if (!nyMeny.isEmpty() || nyMeny != null) {
            this.menyer.add(new Meny(nyMeny));
            return true;
        }
        return false;
    }

    // Å finne alle menyer med totalpris innenfor et gitt intervall.
    public List<Meny> finnMeny(double minTot, double maxTot) {
        Iterator<Meny> menyIterator = this.menyer.iterator();
        List<Meny> menyerFunnet = new ArrayList<>();

        while (menyIterator.hasNext()) {
            Meny meny = menyIterator.next();
            if (meny.getTotalpris() >= minTot && meny.getTotalpris() <= maxTot) {
                menyerFunnet.add(meny);
            }
        }
        return menyerFunnet;
    }
}
