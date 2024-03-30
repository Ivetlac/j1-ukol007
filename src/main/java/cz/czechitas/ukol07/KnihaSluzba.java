package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class KnihaSluzba {
    private List<Kniha> knihy;

    public KnihaSluzba() {
        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("knihy.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            knihy = objectMapper.readValue(inputStream, new TypeReference<List<Kniha>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Kniha> vratVsechnyKnihy() {
        return knihy;
    }

    public List<Kniha> vratKnihyOdAutora(String autor) {
        List<Kniha> knihyOdAutora = new ArrayList<>();
        for (Kniha kniha : knihy) {
            if (kniha.getAutor().equals(autor)) {
                knihyOdAutora.add(kniha);
            }
        }
        return knihyOdAutora;
    }

    public List<Kniha> vratKnihyVydanéVRoce(int rok) {
        List<Kniha> knihyVRoce = new ArrayList<>();
        for (Kniha kniha : knihy) {
            if (kniha.getRokVydani() == rok) {
                knihyVRoce.add(kniha);
            }
        }
        return knihyVRoce;
    }
}
