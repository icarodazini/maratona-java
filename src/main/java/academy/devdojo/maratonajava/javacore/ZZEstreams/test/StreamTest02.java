package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest02 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 7.99),
            new LightNovel("Pokemon", 3.99),
            new LightNovel("Demons Layer", 6.99),
            new LightNovel("Dragon Ball", 1.99),
            new LightNovel("Stranger Things", 8.99)
    ));

    public static void main(String[] args) {
        List<Double> title   = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= 4)
                .limit(3)
                .map(LightNovel::getPrice)
                .collect(Collectors.toList());

        System.out.println(title);
    }
}
