import model.Csoki;
import model.Raktar;
import model.csokik.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaktarTeszt {
    Raktar raktar;
    @BeforeEach
    void setUp() {
        raktar = Raktar.getRaktarPeldany();
        raktar.raktarFeltoltes(new Boci());
    }

    @AfterEach
    void tearDown() {
        Raktar.raktarPeldanyTorlese();
    }

    @Test
    void csokiRaktarhozAdas() throws Exception {
        raktar.hozzaad(new Tibi());
        assertEquals(1, raktar.csokiSzuresMarkavagyIzAlapjan(new Tibi()).size());
    }

    @Test
    void mennyisegMegerositeseMaxFolott() throws Exception{
        assertEquals(false, raktar.nincsTobbCsokiMintHely(new Boci()));
    }

    @Test
    void mennyisegMegerositeseMaxAlatt() throws Exception{
        assertEquals(true, raktar.nincsTobbCsokiMintHely(new Tibi()));
    }

    @Test
    void csokiLekereseMarkaAlapjan() throws Exception{
        Csoki csoki = raktar.csokiMarkaAlapjan("Boci");
        assertEquals(true, csoki instanceof Boci);
    }

    @Test
    void raktarFeltolteseCsokival() throws Exception{
        raktar.raktarFeltoltes(new Milka());
        assertEquals(false, raktar.nincsTobbCsokiMintHely(new Milka()));
    }

    @Test
    void csokiTipusokSzurese() throws Exception{
        assertEquals(200, raktar.csokiSzuresMarkavagyIzAlapjan(new Boci()).size());
    }

    @Test
    void csokiEltavolitasaRaktarbol() throws Exception{
        raktar.csokiEltavolitasaRaktarbol(raktar.csokiMarkaAlapjan("Boci"));
        assertEquals(199, raktar.csokiSzuresMarkavagyIzAlapjan(new Boci()).size());
    }
}