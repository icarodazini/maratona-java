package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class Plane {
    private final Set<String> avaliableSeats = new HashSet<>();
    private final String name;

    public Plane(String name) {
        this.name = name;
    }

    {
        avaliableSeats.add("1A");
        avaliableSeats.add("1B");
    }

    public boolean bookSeats(String seat) {
        return avaliableSeats.remove(seat);
    }
}
