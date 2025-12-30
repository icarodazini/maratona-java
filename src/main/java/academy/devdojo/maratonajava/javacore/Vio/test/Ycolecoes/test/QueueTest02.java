package academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        Queue<Manga> manga = new PriorityQueue<>(new MangaPrecoComparator().reversed());
        manga.add(new Manga(5L, "Dragon Ball", 19.90, 0));
        manga.add(new Manga(2L, "One Piece", 22.90, 5));
        manga.add(new Manga(1L, "Naruto", 18.90, 0));
        manga.add(new Manga(4L, "Bleach", 20.90, 2));
        manga.add(new Manga(3L, "Attack on Titan", 25.90, 0));
        manga.add(new Manga(8L, "Pokemon", 7.20, 3));

        while (!manga.isEmpty()){
            System.out.println(manga.poll());
        }
    }
}
