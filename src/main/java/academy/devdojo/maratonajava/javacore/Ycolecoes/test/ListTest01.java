package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(16);
        List<String> nomes2 = new ArrayList<>(16);
        nomes.add("Goku");
        nomes.add("Vegeta");
        nomes2.add("Trunks");
        nomes2.add("Gohan");

        System.out.println(nomes.remove("Vegeta"));

        nomes.addAll(nomes2);
        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("--------------------");

        int tamanho = nomes.size();
        for (int i = 0; i < tamanho; i++) {
            System.out.println(nomes.get(i));
        }

        System.out.println("--------------------");

        List <Integer> numeros = new ArrayList<>();
        numeros.add(1);
    }
}
