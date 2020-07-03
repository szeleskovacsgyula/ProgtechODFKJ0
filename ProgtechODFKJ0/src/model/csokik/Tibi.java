package model.csokik;

import model.Csoki;

public class Tibi extends Csoki {
    public Tibi() {
        this.ar = 285;
        this.csokiMarka = "Tibi csoki";
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
