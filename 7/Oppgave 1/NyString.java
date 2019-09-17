package com.SteiraEirik;

public final class NyString {
    private final String INPUT;

    public NyString(String INPUT) {
        this.INPUT = INPUT;
    }

    // Forkorting. Forkortingen skal skje ved at første tegn i hvert ord plukkes ut.
    public String forkort() {
        StringBuilder str = new StringBuilder();
        String[] ordLst = this.INPUT.split(" ");

        for (String i : ordLst) {
            str.append(i.toLowerCase().charAt(0));
        }

        return str.toString();
    }

    // Fjerning av tegn.
    public String fjernTegn(String tegn) {
        StringBuilder str = new StringBuilder(this.INPUT);
        for (int i=0; i<str.length();i++) {
            if (!(this.INPUT.contains(tegn)) || str.indexOf(tegn) == -1) {
                break;
            }
            str = str.deleteCharAt(str.indexOf(tegn));
        }

        return str.toString();
    }

    public String getInput() {
        return INPUT;
    }
}
