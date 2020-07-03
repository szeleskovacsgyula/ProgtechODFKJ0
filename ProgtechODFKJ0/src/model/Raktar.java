package model;

import model.addons.FeherCsoki;
import model.addons.MazsolasCsoki;
import model.addons.MogyorosCsoki;
import model.csokik.Boci;
import model.csokik.Milka;
import model.csokik.Sport;
import model.csokik.Tibi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Raktar {
    private static Raktar egyeduliRaktarPeldany = null;
    private static final int maximumMennyiseg = 200;
    private List<Csoki> csokiRaktar;

    private Raktar() {
        csokiRaktar = new ArrayList<Csoki>();
    }
    public static Raktar getRaktarPeldany() {
        if (egyeduliRaktarPeldany == null) {
            egyeduliRaktarPeldany = new Raktar();
        }
        return egyeduliRaktarPeldany;
    }

    public static void raktarPeldanyTorlese() {
        egyeduliRaktarPeldany = null;
    }

    public void hozzaad(Csoki csoki) throws Exception {
        if (nincsTobbCsokiMintHely(csoki)) {
            csokiRaktar.add(csoki);
        } else {
            throw new Exception("A raktár tele van");
        }
    }

    public void csokiEltavolitasaRaktarbol(Csoki csoki) throws Exception {
        if (csokiRaktar.contains(csoki)){
            csokiRaktar.remove(csoki);
        } else  {
            throw new Exception("Nincs raktáron ebből a fajtából");
        }
    }

    public String raktarKilistazasFajtakAlapjan() {
        String temp = "Boci: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> csoki instanceof Boci).count()) + "\n";
        temp += "Tibi: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> csoki instanceof Tibi).count()) + "\n";
        temp += "Milka: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> csoki instanceof Milka).count()) + "\n";
        temp += "Sport: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> csoki instanceof Sport).count()) + "\n";
        temp += "Boci fehér csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof FeherCsoki &&
                ((FeherCsoki) csoki).csoki instanceof Boci)).count()) + "\n";
        temp += "Tibi fehér csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof FeherCsoki &&
                ((FeherCsoki) csoki).csoki instanceof Tibi)).count()) + "\n";
        temp += "Sport fehér csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof FeherCsoki &&
                ((FeherCsoki) csoki).csoki instanceof Sport)).count()) + "\n";
        temp += "Milka fehér csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof FeherCsoki &&
                ((FeherCsoki) csoki).csoki instanceof Milka)).count()) + "\n";
        temp += "Boci mogyorós csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof MogyorosCsoki &&
                ((MogyorosCsoki) csoki).csoki instanceof Boci)).count()) + "\n";
        temp += "Tibi mogyorós csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof MogyorosCsoki &&
                ((MogyorosCsoki) csoki).csoki instanceof Tibi)).count()) + "\n";
        temp += "Sport mogyorós csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof MogyorosCsoki &&
                ((MogyorosCsoki) csoki).csoki instanceof Sport)).count()) + "\n";
        temp += "Milka mogyorós csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof MogyorosCsoki &&
                ((MogyorosCsoki) csoki).csoki instanceof Milka)).count()) + "\n";
        temp += "Boci mazsolás csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof MazsolasCsoki &&
                ((MazsolasCsoki) csoki).csoki instanceof Boci)).count()) + "\n";
        temp += "Tibi mazsolás csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof MazsolasCsoki &&
                ((MazsolasCsoki) csoki).csoki instanceof Tibi)).count()) + "\n";
        temp += "Sport mazsolás csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof MazsolasCsoki &&
                ((MazsolasCsoki) csoki).csoki instanceof Sport)).count()) + "\n";
        temp += "Milka mazsolás csoki: ";
        temp += Long.toString(csokiRaktar.stream().filter(csoki -> (csoki instanceof MazsolasCsoki &&
                ((MazsolasCsoki) csoki).csoki instanceof Milka)).count()) + "\n";
        return temp;
    }

    public boolean nincsTobbCsokiMintHely(Csoki csoki) throws IllegalArgumentException {
        if(!csokiRaktar.isEmpty()) {
            if (csoki instanceof Boci) {
                if(csokiRaktar.stream().filter(c -> c instanceof Boci).count() >= maximumMennyiseg)  return false;
            }
            else if(csoki instanceof Tibi) {
                if(csokiRaktar.stream().filter(c -> c instanceof Tibi).count() >= maximumMennyiseg)  return false;
            }
            else if(csoki instanceof Sport) {
                if(csokiRaktar.stream().filter(c -> c instanceof Sport).count() >= maximumMennyiseg)  return false;
            }
            else if(csoki instanceof Milka) {
                if(csokiRaktar.stream().filter(c -> c instanceof Milka).count() >= maximumMennyiseg)  return false;
            }
            else if(csoki instanceof FeherCsoki) {
                if(csokiRaktar.stream().filter(c -> c instanceof FeherCsoki).count() >= maximumMennyiseg)  return false;
            }
            else if(csoki instanceof MogyorosCsoki) {
                if(csokiRaktar.stream().filter(c -> c instanceof MogyorosCsoki).count() >= maximumMennyiseg)  return false;
            }
            else if(csoki instanceof MazsolasCsoki) {
                if(csokiRaktar.stream().filter(c -> c instanceof MazsolasCsoki).count() >= maximumMennyiseg)  return false;
            }
            else {
                throw new IllegalArgumentException("Több csoki van mint hely a raktárban!");
            }
        }
        return true;
    }

    public Csoki csokiMarkaAlapjan(String csokiMarka) throws Exception {
        Csoki rendeltCsoki;
        try {
            rendeltCsoki = csokiRaktar.stream().filter(csoki -> csoki.getClass().getSimpleName().toLowerCase().equals(csokiMarka.toLowerCase())).findFirst().get();
        } catch(Exception e) {
            throw new Exception("Nincs ebből a márkából csoki!");
        }
        return rendeltCsoki;
    }

    public ArrayList<Csoki> csokiSzuresMarkavagyIzAlapjan(Csoki csoki) throws Exception{
        if(!csokiRaktar.isEmpty()) {
            if (csoki instanceof Boci) {
                return new ArrayList<Csoki>(csokiRaktar.stream().filter(c -> c instanceof Boci).collect(Collectors.toList()));
            } else if (csoki instanceof Tibi) {
                return new ArrayList<Csoki>(csokiRaktar.stream().filter(c -> c instanceof Tibi).collect(Collectors.toList()));
            } else if (csoki instanceof Sport) {
                return new ArrayList<Csoki>(csokiRaktar.stream().filter(c -> c instanceof Sport).collect(Collectors.toList()));
            } else if (csoki instanceof Milka) {
                return new ArrayList<Csoki>(csokiRaktar.stream().filter(c -> c instanceof Milka).collect(Collectors.toList()));
            } else if (csoki instanceof FeherCsoki) {
                return new ArrayList<Csoki>(csokiRaktar.stream().filter(c -> c instanceof FeherCsoki).collect(Collectors.toList()));
            } else if (csoki instanceof MogyorosCsoki) {
                return new ArrayList<Csoki>(csokiRaktar.stream().filter(c -> c instanceof MogyorosCsoki).collect(Collectors.toList()));
            } else if (csoki instanceof MazsolasCsoki) {
                return new ArrayList<Csoki>(csokiRaktar.stream().filter(c -> c instanceof MazsolasCsoki).collect(Collectors.toList()));
            } else {
                throw new Exception("Nem megfelelő  a megadott paraméter");
            }
        } else {
            throw new Exception("A raktár üres");
        }
    }

    public void raktarFeltoltes(Csoki csoki) {
        while (nincsTobbCsokiMintHely(csoki)) {
            if (csoki instanceof Boci) csokiRaktar.add(new Boci());
            if (csoki instanceof Tibi) csokiRaktar.add(new Tibi());
            if (csoki instanceof Sport) csokiRaktar.add(new Sport());
            if (csoki instanceof Milka) csokiRaktar.add(new Milka());
            if (csoki instanceof FeherCsoki) csokiRaktar.add(new FeherCsoki(((FeherCsoki) csoki).csoki));
            if (csoki instanceof MogyorosCsoki) csokiRaktar.add(new MogyorosCsoki(((MogyorosCsoki) csoki).csoki));
            if (csoki instanceof MazsolasCsoki) csokiRaktar.add(new MazsolasCsoki(((MazsolasCsoki) csoki).csoki));
        }
    }
}
