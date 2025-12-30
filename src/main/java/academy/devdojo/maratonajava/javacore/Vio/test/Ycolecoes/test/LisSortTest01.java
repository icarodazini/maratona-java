package academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LisSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Dragon Ball");
        mangas.add("One Piece");
        mangas.add("Naruto");
        mangas.add("Bleach");
        mangas.add("Death Note");

        Collections.sort(mangas);

        List<Double> notas = new ArrayList<>(6);
        notas.add(7.0);
        notas.add(8.0);
        notas.add(6.0);
        notas.add(9.0);

        for (String manga : mangas) {
            System.out.println(manga);
        }
        System.out.println(notas);
        Collections.sort(notas);
        System.out.println(notas);
    }
}
