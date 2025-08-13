package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 10.99),
            new LightNovel("Pokemon", 3.99),
            new LightNovel("Demons Layer", 6.99),
            new LightNovel("Dragon Ball", 1.99),
            new LightNovel("Stranger Things", 8.99),
            new LightNovel("Stranger Things", 1.99),
            new LightNovel("Prision break", 8.99)
    ));

    public static void main(String[] args) {
        lightNovels
                .stream()
                .map(LightNovel::getPrice)
                .filter(price -> price > 3)
                .reduce(Double::sum)
                .ifPresent(System.out::println);

        double sum = lightNovels.stream()
                .mapToDouble(LightNovel::getPrice)
                .filter(price -> price > 3)
                .sum();
    }
}
