package model;

import interfacek.IRaktarAllapot;

public abstract class Csoki implements IRaktarAllapot {
    protected int ar;
    protected String csokiMarka;

    public abstract int getAr();
    public abstract void setAr(int ar);

    public abstract String getCsoki();
    public abstract void setCsoki(String csoki);

    public void frissites(int ar) {
        setAr(ar);
    }
}
