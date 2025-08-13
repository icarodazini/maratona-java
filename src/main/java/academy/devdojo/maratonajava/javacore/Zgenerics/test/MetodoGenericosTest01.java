package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.List;

public class MetodoGenericosTest01 {
    public static void main(String[] args) {
        List<Barco> navio = criarArrayComUmObjeto(new Barco("Navio"));
        System.out.println(navio);
    }

    private static <T> List<T> criarArrayComUmObjeto(T t) {
        return List.of(t);
    }

//    private static <T extends Comparable<T>> List<T> criarArrayComUmObjeto(T t) {
//        return List.of(t);
//    }
}
