package model.csokik;

import model.Csoki;

public class Boci extends Csoki {
    public Boci() {
        this.ar = 250;
        this.csokiMarka = "Boci csoki";
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
