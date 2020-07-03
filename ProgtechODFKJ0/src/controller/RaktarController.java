package controller;

import interfacek.ITargy;
import letrehozas.CsokiLetrehozas;
import model.Csoki;
import model.Raktar;
import view.ErtekMegjelenites;
import view.Megjelenites;
import view.RaktarMegjelenites;

import static java.lang.Integer.parseInt;

public class RaktarController implements ITargy {
    private static Raktar raktar;
    private RaktarMegjelenites raktarMegjelenites;
    private ErtekMegjelenites ertekMegjelenites;

    public RaktarController() {
        raktar = Raktar.getRaktarPeldany();
        raktarMegjelenites = new RaktarMegjelenites();
        ertekMegjelenites = new ErtekMegjelenites();
    }

    public void raktarAlapallapot() {
        raktarFeltoltes("Boci", null);
        raktarFeltoltes("Milka", null);
        raktarFeltoltes("Sport", null);
        raktarFeltoltes("Tibi", null);
    }

    public void bevitelKezeles() throws Exception {
            String bevitel = Megjelenites.bevitelOlvasasa(raktarMegjelenites.getElvegzendoMulvelet());
            String csokiMarka;
            String izesites;
            switch(bevitel) {
                case "1":
                    csokiMarka = csokiMarkaValasztas();
                    izesites = izesitesKivalasztas();
                    csokiRendeles(csokiMarka, izesites);
                    break;
                case "2":
                    csokiMarka = csokiMarkaValasztas();
                    izesites = izesitesKivalasztas();
                    raktarFeltoltes(csokiMarka, izesites);
                    break;
                case "3":
                    Megjelenites.adatokMegjelenitese(raktar.raktarKilistazasFajtakAlapjan());
                    break;
                case "4":
                    csokiMarka = csokiMarkaValasztas();
                    izesites = izesitesKivalasztas();
                    int ar = parseInt(Megjelenites.bevitelOlvasasa(ertekMegjelenites.getErtekValtoztatas()));
                    arBeallitas(csokiMarka, izesites, ar);
                case "q":
                    System.exit(0);
                    break;
                default:
                    throw new IllegalArgumentException("A bemeneti érték nem megfelelő!");
            }
    }

    public void csokiRaktarhozAdas(String valasztottCsokiMarka, String valasztottIzesites) throws Exception {
        raktar.hozzaad(csokiHozzadas(valasztottCsokiMarka, valasztottIzesites));
    }

    public void csokiEltavolitasaRaktarbol(Csoki csoki) throws Exception {
        raktar.csokiEltavolitasaRaktarbol(csoki);
    }

    public void raktarFeltoltes(String csokiMarka, String izesites) {
        raktar.raktarFeltoltes(CsokiLetrehozas.csokiLetrehozas(csokiMarka, izesites));
    }

    public void megfigyeloErtesites(Csoki csoki, int ar) throws Exception {
        for (Csoki csoki1 : raktar.csokiSzuresMarkavagyIzAlapjan(csoki)) {
            csoki1.frissites(ar);
        }
        throw new Exception("A " + csoki.getClass().getSimpleName() +  "ára: " + ar);
    }

    public Csoki csokiHozzadas(String valasztottCsokiMarka, String izesites) throws IllegalArgumentException{
        switch(valasztottCsokiMarka) {
            case "1":
                return CsokiLetrehozas.csokiLetrehozas("Boci", izesites);
            case "2":
                return CsokiLetrehozas.csokiLetrehozas("Milka", izesites);
            case "3":
                return CsokiLetrehozas.csokiLetrehozas("Sport", izesites);
            case "4":
                return CsokiLetrehozas.csokiLetrehozas("Tibi", izesites);
            default:
                throw new IllegalArgumentException("A bemeneti érték nem megfelelő!");
        }
    }

    public String izesitesKivalasztas() throws IllegalArgumentException {
        String izesitvevan = Megjelenites.bevitelOlvasasa(raktarMegjelenites.getSzuksegesIzesites());
        if(izesitvevan.toLowerCase().equals("i")) {
            switch (Megjelenites.bevitelOlvasasa(raktarMegjelenites.getIzesitesOpcio())) {
                case "1":
                    return "fehér";
                case "2":
                    return "mogyorós";
                case "3":
                    return "mazsolás";
                default:
                    throw new IllegalArgumentException("A bemeneti érték nem megfelelő!");
            }
        }else if (izesitvevan.toLowerCase().equals("n")) {
            return null;
        }else {
            throw new IllegalArgumentException("A bemeneti érték nem megfelelő!");
        }
    }

    public String csokiMarkaValasztas() throws IllegalArgumentException {
        String csokiMarka = Megjelenites.bevitelOlvasasa(raktarMegjelenites.getCsokiMarkak());
        if(csokiMarka.equals("1")) {
            return "Boci";
        }else if (csokiMarka.equals("2")) {
            return "Milka";
        }else if (csokiMarka.equals("3")) {
            return "Sport";
        }
        else if (csokiMarka.equals("4")) {
            return "Tibi";
        }
        else {
            throw new IllegalArgumentException("A bemeneti érték nem megfelelő!");
        }
    }

    public void csokiRendeles(String csokiMarka, String izesites) throws Exception {
        Csoki csoki = raktar.csokiMarkaAlapjan((izesites != null) ? izesites : csokiMarka);
        String response = "A rendelt csoki értéke: " + csoki.getAr() +" huf";
        csokiEltavolitasaRaktarbol(csoki);
        Megjelenites.adatokMegjelenitese(response);
    }

    public void arBeallitas(String csokiMarka, String izesites, int ar) throws Exception {
        Csoki csoki = raktar.csokiMarkaAlapjan((izesites != null) ? izesites : csokiMarka);
        megfigyeloErtesites(csoki, ar);
    }
}
