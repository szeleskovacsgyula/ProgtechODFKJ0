package model;

public abstract class IzesitesHozzaadas extends Csoki {
    protected Csoki csoki;

    public IzesitesHozzaadas(Csoki csoki) {
        this.csoki = csoki;
    }

    @Override
    public int getAr() {
        return csoki.getAr();
    }

    @Override
    public void setAr(int ar) {
        csoki.setAr(ar);
    }

    @Override
    public String getCsoki() {
        return csoki.getCsoki();
    }

    @Override
    public void setCsoki(String csoki) {
        this.csoki.setCsoki(csoki);
    }
}
