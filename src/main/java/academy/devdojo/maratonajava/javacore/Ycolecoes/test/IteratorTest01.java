package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new LinkedList<>();
        mangas.add(new Manga(5L, "Dragon Ball", 19.90, 0));
        mangas.add(new Manga(2L, "One Piece", 22.90, 5));
        mangas.add(new Manga(1L, "Naruto", 18.90, 0));
        mangas.add(new Manga(4L, "Bleach", 20.90, 2));
        mangas.add(new Manga(3L, "Attack on Titan", 25.90, 0));

        /*
        Iterator<Manga> mangaIterator = mangas.iterator();
        while (mangaIterator.hasNext()) {
            Manga manga = mangaIterator.next();
            if (manga.getQuantidade() == 0) {
                mangaIterator.remove();
            }
        }
         */
        mangas.removeIf(manga -> manga.getQuantidade() == 0);

        System.out.println(mangas);
    }
}
