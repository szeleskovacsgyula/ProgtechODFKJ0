package model.addons;

import model.Csoki;
import model.IzesitesHozzaadas;

public class MogyorosCsoki extends IzesitesHozzaadas {
    public MogyorosCsoki(Csoki csoki) {
        super(csoki);
        this.ar = super.getAr() + 50;
        this.csokiMarka = super.getCsoki() + " mogyoró darabokkal";
    }

    @Override
    public int getAr() {
        return ar;
    }

    @Override
    public void setAr(int ar) {
        this.ar = super.getAr() + ar;
    }

    @Override
    public String getCsoki() {
        return this.csokiMarka;
    }

    @Override
    public void setCsoki(String csoki) {
        this.csokiMarka =  super.getCsoki() + csoki;
    }
}
