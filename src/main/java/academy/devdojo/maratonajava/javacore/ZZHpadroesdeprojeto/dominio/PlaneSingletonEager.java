package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public class PlaneSingletonEager {
    private static final PlaneSingletonEager INSTANCE = new PlaneSingletonEager("787-900");
    private final Set<String> avaliableSeats = new HashSet<>();
    private final String name;

    private PlaneSingletonEager(String name) {
        this.name = name;
    }

    {
        avaliableSeats.add("1A");
        avaliableSeats.add("1B");
    }

    public static PlaneSingletonEager getINSTACE() {
        return INSTANCE;
    }

    public boolean bookSeats(String seat) {
        return avaliableSeats.remove(seat);
    }
}
