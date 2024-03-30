package cz.czechitas.ukol07;

import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Aplikace {
    public static void main(String[] args) {
        KnihaSluzba knihaSluzba = new KnihaSluzba();

        List<Kniha> vsechnyKnihy = knihaSluzba.vratVsechnyKnihy();
        System.out.println("Celkový počet knih: " + vsechnyKnihy.size());

        System.out.println("Knihy od autora Karla Čapka:");
        List<Kniha> knihyOdCapeka = knihaSluzba.vratKnihyOdAutora("Karel Čapek");
        for (Kniha kniha : knihyOdCapeka) {
            System.out.println(kniha.getAutor() + ": " + kniha.getNazev());
        }

        System.out.println("Knihy vydané v roce 1845:");
        List<Kniha> knihyVRoce1845 = knihaSluzba.vratKnihyVydanéVRoce(1845);
        for (Kniha kniha : knihyVRoce1845) {
            System.out.println(kniha.getAutor() + ": " + kniha.getNazev());
        }
    }
}
