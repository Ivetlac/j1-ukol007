package cz.czechitas.ukol07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class Test {

    private KnihaSluzba knihaSluzba;

    @BeforeEach
    public void setUp() {
        knihaSluzba = new KnihaSluzba();
    }

    @org.junit.jupiter.api.Test
    public void testVratVsechnyKnihy() {
        List<Kniha> knihy = knihaSluzba.vratVsechnyKnihy();
        Assertions.assertNotNull(knihy);
        Assertions.assertFalse(knihy.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testVratKnihyOdExistujicihoAutora() {
        String autor = "Božena Němcová";
        List<Kniha> knihyOdAutora = knihaSluzba.vratKnihyOdAutora(autor);
        Assertions.assertFalse(knihyOdAutora.isEmpty());
        for (Kniha kniha : knihyOdAutora) {
            Assertions.assertEquals(autor, kniha.getAutor());
        }
    }

    @org.junit.jupiter.api.Test
    public void testVratKnihyOdNeexistujicihoAutora() {
        String autor = "Neexistujici Autor";
        List<Kniha> knihyOdAutora = knihaSluzba.vratKnihyOdAutora(autor);
        Assertions.assertTrue(knihyOdAutora.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testVratKnihyVRoce() {
        int rok = 1856;
        List<Kniha> knihyVRoce = knihaSluzba.vratKnihyVydanéVRoce(rok);
        Assertions.assertFalse(knihyVRoce.isEmpty());
        for (Kniha kniha : knihyVRoce) {
            Assertions.assertEquals(rok, kniha.getRokVydani());
        }
    }

    @org.junit.jupiter.api.Test
    public void testVratKnihyVRoceBezKnihVRoce() {
        int rok = 2024;
        List<Kniha> knihyVRoce = knihaSluzba.vratKnihyVydanéVRoce(rok);
        Assertions.assertTrue(knihyVRoce.isEmpty());
    }
}

