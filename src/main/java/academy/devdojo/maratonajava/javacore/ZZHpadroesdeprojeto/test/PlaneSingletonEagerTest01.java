package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.PlaneSingletonEager;

public class PlaneSingletonEagerTest01 {
    public static void main(String[] args) {
        bookSeats("1A");
        bookSeats("1A");
        PlaneTest01.bookSeats("1A");
    }
    static void bookSeats(String seat) {
        System.out.println(PlaneSingletonEager.getINSTACE());
        PlaneSingletonEager planeSingletonEager = PlaneSingletonEager.getINSTACE();
        System.out.println(planeSingletonEager.bookSeats(seat));
    }
}
