package academy.devdojo.maratonajava.javacore.ZZKjunit.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // gera getters, setters, equals, hashCode, toString
@AllArgsConstructor // gera construtor cheio
@NoArgsConstructor // gera construtor vazio (obrigatorio para o JPA)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    public Person(int age) {
        this.age = age;    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
