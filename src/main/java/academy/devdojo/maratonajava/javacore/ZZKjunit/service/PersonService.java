package academy.devdojo.maratonajava.javacore.ZZKjunit.service;

import academy.devdojo.maratonajava.javacore.ZZKjunit.dominio.Person;
import academy.devdojo.maratonajava.javacore.ZZKjunit.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Cria o construtor para o Spring injetar o Repository
public class PersonService {

    private final PersonRepository repository;

    public Person save(Person person) {
        return repository.save(person);
    }

    public List<Person> listAllAdult() {
        return repository.findAll().stream()
                .filter(p -> p.getAge() >= 18)
                .collect(Collectors.toList());
    }
}
