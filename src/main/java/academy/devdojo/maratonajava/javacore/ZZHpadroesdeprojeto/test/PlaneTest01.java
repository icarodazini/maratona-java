package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Plane;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.PlaneSingletonEager;

public class PlaneTest01 {
    public static void main(String[] args) {
        bookSeats("1A");
        bookSeats("1A");
    }

    static void bookSeats(String seat){
        System.out.println(PlaneSingletonEager.getINSTACE());
        Plane plane = new Plane("787-900");
        System.out.println(plane.bookSeats(seat));
    }
}
