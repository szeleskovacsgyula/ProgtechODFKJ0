package letrehozas;

import model.Csoki;
import model.addons.FeherCsoki;
import model.addons.MazsolasCsoki;
import model.addons.MogyorosCsoki;
import model.csokik.Boci;
import model.csokik.Milka;
import model.csokik.Sport;
import model.csokik.Tibi;

public class CsokiLetrehozas {
    public static Csoki csokiLetrehozas(String csokiMarka, String izesites) throws IllegalArgumentException {
        if(csokiMarka.toLowerCase().equals("boci")) {
            if (izesites != null) {
                return izesitesHozzaadas(new Boci(), izesites);
            }
            return new Boci();
        }
        else if(csokiMarka.toLowerCase().equals("tibi")) {
            if (izesites != null) {
                return izesitesHozzaadas(new Tibi(), izesites);
            }
            return new Tibi();
        }
        else if(csokiMarka.toLowerCase().equals("sport")) {
            if (izesites != null) {
                return izesitesHozzaadas(new Sport(), izesites);
            }
            return new Sport();
        }
        else if(csokiMarka.toLowerCase().equals("milka")) {
            if (izesites != null) {
                return izesitesHozzaadas(new Milka(), izesites);
            }
            return new Milka();
        }
        else {
            throw new IllegalArgumentException("A paraméter nem megfelelő");
        }
    }

    public static Csoki izesitesHozzaadas(Csoki csoki, String izesites) throws IllegalArgumentException {
        if(izesites.toLowerCase().equals("fehér")) {
            return new FeherCsoki(csoki);
        }
        else if(izesites.toLowerCase().equals("mogyorós")) {
            return new MogyorosCsoki(csoki);
        }
        else if(izesites.toLowerCase().equals("mazsolás")) {
            return new MazsolasCsoki(csoki);
        }
        else {
            throw new IllegalArgumentException("A paraméter nem megfelelő");
        }
    }
}
