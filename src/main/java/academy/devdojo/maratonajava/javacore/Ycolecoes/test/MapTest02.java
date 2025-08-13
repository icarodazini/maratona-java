package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Icaro");
        Consumidor consumidor2 = new Consumidor("Carrilho");

        Manga manga1 = new Manga(5L, "Dragon Ball", 19.90);
        Manga manga2 = new Manga(2L, "One Piece", 22.90);
        Manga manga3 = new Manga(1L, "Naruto", 18.90);
        Manga manga4 = new Manga(4L, "Bleach", 20.90);
        Manga manga5 = new Manga(3L, "Attack on Titan", 25.90);

        Map<Consumidor, Manga> consumidorManga = new HashMap<>();
        consumidorManga.put(consumidor1, manga1);
        consumidorManga.put(consumidor2, manga2);

        for (Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()){
            System.out.println(entry.getKey().getNome() + " : " + entry.getValue().getNome());
        }
    }
}
