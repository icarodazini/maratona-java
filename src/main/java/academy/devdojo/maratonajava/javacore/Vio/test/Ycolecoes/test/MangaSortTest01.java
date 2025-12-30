package academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga m1, Manga m2) {
        return m1.compareTo(m2);
    }
}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Dragon Ball", 19.90));
        mangas.add(new Manga(2L, "One Piece", 22.90));
        mangas.add(new Manga(1L, "Naruto", 18.90));
        mangas.add(new Manga(4L, "Bleach", 20.90));
        mangas.add(new Manga(3L, "Attack on Titan", 25.90));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        Collections.sort(mangas);
        System.out.println("\n----- Ordenando -----");
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Collections.sort(mangas, new MangaByIdComparator());
        System.out.println("\n----- Ordenando -----");
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
