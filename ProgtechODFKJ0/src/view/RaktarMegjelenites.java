package view;

public class RaktarMegjelenites extends Megjelenites {
    private String elvegzendoMulvelet = " Csokiraktar \n"
            + "1. Rendelés\n2. Raktár feltöltése\n3. Raktár állapot\n4. Ármódosítás\nq. Kilépés";
    private String csokiMarkak = "Üsse be a márka számát!\n"
            + "1. Boci\n2. Milka\n3. Sport\n4. Tibi\n";
    private String szuksegesIzesites = "Szükség van egyedi ízre? (i/n)";
    private String izesitesOpcio = "Üsse be a megfelelő íz számát!\n"
            + "1. Fehér\n2. Mogyorós\n3. Mazsolás\n";

    public String getElvegzendoMulvelet() {
        return this.elvegzendoMulvelet;
    }
    public String getCsokiMarkak() {
        return this.csokiMarkak;
    }
    public String getSzuksegesIzesites() {
        return this.szuksegesIzesites;
    }
    public String getIzesitesOpcio() {
        return this.izesitesOpcio;
    }
}
