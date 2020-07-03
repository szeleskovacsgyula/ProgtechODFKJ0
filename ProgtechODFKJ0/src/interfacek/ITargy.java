package interfacek;

import model.Csoki;

public interface ITargy {
    public void raktarFeltoltes(String csokiMarka, String izesites);
    public void csokiEltavolitasaRaktarbol(Csoki csoki) throws Exception;
    public void megfigyeloErtesites(Csoki csoki, int ar) throws Exception;
}
