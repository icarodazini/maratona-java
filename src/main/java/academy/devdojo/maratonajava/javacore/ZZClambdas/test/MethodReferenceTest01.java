package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime(" Dragon Ball", 7), new Anime("Naruto", 100), new Anime("Pokemon Go", 36)));
        animeList.sort((a1, a2) -> a1.getTittle().compareTo(a2.getTittle()));
        animeList.sort(AnimeComparators::compareByTittle);
        animeList.sort(AnimeComparators::compareByEpisodes);
        System.out.println(animeList);
    }
}
