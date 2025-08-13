package academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    private static List<Manga>  mangas = List.of(new Manga(1,"naruto",33), new Manga(2,"pokemon",65));

    public static Optional<Manga> findById(Integer id){
        return findBy(m -> m.getId().equals(id));
    }

    public static Optional<Manga> findByTittle(String tittle){
        return findBy(m -> m.getTittle().equals(tittle));
    }

    private static Optional<Manga> findBy(Predicate<Manga> mangaPredicate){
        Manga found = null;
        for (Manga manga : mangas){
            if (mangaPredicate.test(manga)){
                found  = manga;
            }
        }
        return Optional.ofNullable(found);
    }
}
