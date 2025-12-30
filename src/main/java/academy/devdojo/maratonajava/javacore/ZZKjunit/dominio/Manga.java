package academy.devdojo.maratonajava.javacore.ZZKjunit.dominio;

import java.util.Objects;

public record Manga(String name, double episodes) {

    public Manga {
        Objects.requireNonNull(name);
    }
}
