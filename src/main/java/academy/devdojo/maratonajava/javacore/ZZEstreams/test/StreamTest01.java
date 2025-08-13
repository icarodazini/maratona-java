package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest01 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Naruto", 7.99),
            new LightNovel("Pokemon", 3.99),
            new LightNovel("Demons Layer", 6.99),
            new LightNovel("Dragon Ball", 1.99),
            new LightNovel("Stranger Things", 8.99)
    ));

    public static void main(String[] args) {
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels){
            if (lightNovel.getPrice() <= 4){
                titles.add(lightNovel.getTitle());
            }
            if (titles.size() >=3){
                break;
            }
        }

        System.out.println(lightNovels);
        System.out.println(titles);
    }
}
