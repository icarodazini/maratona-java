package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.test.Animal;
import academy.devdojo.maratonajava.javacore.Zgenerics.test.Cachorro;
import academy.devdojo.maratonajava.javacore.Zgenerics.test.Gato;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        List<Cachorro> cachorroList = List.of(new Cachorro());
        List<Gato> gatoList = List.of(new Gato());
        printConsulta(cachorroList);
        printConsulta(gatoList);
        List<Animal> animals = new ArrayList<>();
        printConsulta(animals);
    }

    private static void printConsulta(List< ? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }
    }
    private static void printConsultaAnimal(List<? super Animal> animals){
        animals.add(new Cachorro());
        animals.add(new Gato());
    }
}
