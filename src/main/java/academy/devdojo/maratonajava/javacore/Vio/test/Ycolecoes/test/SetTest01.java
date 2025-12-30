package academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.dominio.Manga;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<Manga> mangas = new LinkedHashSet<>();
        mangas.add(new Manga(5L, "Dragon Ball", 19.90, 0));
        mangas.add(new Manga(2L, "One Piece", 22.90, 5));
        mangas.add(new Manga(1L, "Naruto", 18.90, 0));
        mangas.add(new Manga(4L, "Bleach", 20.90, 2));
        mangas.add(new Manga(3L, "Attack on Titan", 25.90, 0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
