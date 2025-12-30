package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Vio.test.Ycolecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("icaro");
        list.add("icaro");

        for (Object o : list) {
            System.out.println(o);
        }
        add(list, new Consumidor("Claudio"));
    }
    private static void add(List list, Consumidor consumidor){
        list.add(consumidor);
    }
}
