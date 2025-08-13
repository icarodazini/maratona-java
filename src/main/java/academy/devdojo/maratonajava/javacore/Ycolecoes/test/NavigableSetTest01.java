package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}

public class NavigableSetTest01 {
    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "iPhone 14");
        set.add(smartphone);
        System.out.println(set);
        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L, "Dragon Ball", 19.90, 0));
        mangas.add(new Manga(2L, "One Piece", 22.90, 5));
        mangas.add(new Manga(1L, "Naruto", 18.90, 0));
        mangas.add(new Manga(4L, "Bleach", 20.90, 2));
        mangas.add(new Manga(3L, "Attack on Titan", 25.90, 0));
        mangas.add(new Manga(8L, "Pokemon", 7.20, 3));

        for (Manga manga : mangas.descendingSet()) {
            System.out.println(manga);
        }
        System.out.println("==================================");
        Manga yuyu = new Manga(22L, "Yuyu hawshow", 8.4, 5);

        // lower <
        // floor <=
        // higher >
        // ceiling >=
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));

        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst());
        System.out.println(mangas.pollLast());
    }
}
