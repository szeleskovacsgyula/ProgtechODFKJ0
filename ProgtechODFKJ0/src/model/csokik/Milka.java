package model.csokik;

import model.Csoki;

public class Milka extends Csoki {
    public Milka() {
        this.ar = 300;
        this.csokiMarka = "Milka csoki";
    }

    @Override
    public int getAr() {
        return ar;
    }

    @Override
    public void setAr(int ar) {
        this.ar = ar;
    }

    @Override
    public String getCsoki() {
        return csokiMarka;
    }

    @Override
    public void setCsoki(String csoki) {
        this.csokiMarka = csoki;
    }
}
