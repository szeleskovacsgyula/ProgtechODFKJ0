package model.csokik;

import model.Csoki;

public class Sport extends Csoki {
    public Sport() {
        this.ar = 180;
        this.csokiMarka = "Sport csoki";
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
