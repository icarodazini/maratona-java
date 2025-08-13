package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        Optional<Manga> manga = MangaRepository.findByTittle("pokemon");
        manga.ifPresent(m -> m.setTittle("pokemon 2"));
        System.out.println(manga);

        Manga mangaById = MangaRepository.findById(2)
                .orElseThrow(IllegalArgumentException::new);

        System.out.println(mangaById);

        Manga mangaByTittle = MangaRepository.findByTittle("Naturo")
                .orElse(new Manga(3, "Naruto", 20));

        System.out.println(mangaByTittle);
    }
}
