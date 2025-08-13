package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> school = new ArrayList<>();
        List<String> graphicDesigners = List.of("Icaro Dazini", "Lucas Carrilho", "Heloisa Helena");
        List<String> developers = List.of("Claudio", "Maria", "Afonso");
        List<String> students = List.of("Oraci", "Heleonor", "Jannet", "Alvim");
        System.out.println(graphicDesigners);
        System.out.println(developers);
        System.out.println(students);

        for (List<String> people : school) {
            for (String person : people) {
                System.out.println(person);
            }
        }
        System.out.println("------------------");
        school.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
