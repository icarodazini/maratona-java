package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 10.99, Category.DRAMA),
            new LightNovel("Pokemon", 3.99, Category.FANTASY),
            new LightNovel("Demons Layer", 6.99, Category.ROMANCE),
            new LightNovel("Dragon Ball", 1.99, Category.DRAMA),
            new LightNovel("Stranger Things", 8.99, Category.FANTASY),
            new LightNovel("Stranger Things", 1.99, Category.FANTASY),
            new LightNovel("Prision break", 8.99, Category.DRAMA)
    ));

    public static void main(String[] args) {
        Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();

        Map<Category, List<LightNovel>> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        System.out.println(collect);
    }
}
