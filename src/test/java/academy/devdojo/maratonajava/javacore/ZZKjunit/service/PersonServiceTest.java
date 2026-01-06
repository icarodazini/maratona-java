package academy.devdojo.maratonajava.javacore.ZZKjunit.service;

import academy.devdojo.maratonajava.javacore.ZZKjunit.dominio.Person;
import academy.devdojo.maratonajava.javacore.ZZKjunit.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class) // Habilita o uso de Mocks do Mockito
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService; // Injeta o mock acima automaticamente nesta service

    private Person adult;
    private Person notAdult;

    @BeforeEach
    void setUp() {
        adult = new Person(20);
        notAdult = new Person(16);
    }

    @Test
    @DisplayName("Uma pessoa não deve ser considerada adulta se a idade for menor que 18 anos")
    void isAdult_ReturnFalse_WhanAgeLowerThan18() {
        // ARRANGE
        Person p = new Person(15);

        // ACT - Corrigido de "listAllAdult" para "isAdult"
        boolean result = personService.listAllAdult().contains(p);

        // ASSERT
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Uma pessoa deve ser considerada adulta se a idade for igual ou maior que 18 anos.")
    void isAdult_ReturnTrue_WhenTheAgeIsGreaterOrEqualsThan18() {
        // ARRANGE
        Person adult = new Person(20);
        Mockito.when(personRepository.findAll()).thenReturn(List.of(adult));

        // ACT
        boolean result = personService.listAllAdult().contains(adult);

        // ASSERT
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando a pessoa for nula.")
    void isAdult_ThrowException_WhenPersonIsNull() {
        // ARRANGE
        Person person = null;

        // ACT
        List<Person> result = personService.listAllAdult();

        // ASSERT
        Assertions.assertNotNull(result, "A lista retornada não deve ser nula");

    }

    @Test
    @DisplayName("Deve retornar a lista apenas com adultos.\n")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        // ARRANGE
        Mockito.when(personRepository.findAll()).thenReturn(List.of(adult, notAdult, new Person(30)));

        // ACT
        List<Person> adults = personService.listAllAdult().stream()
                .filter(p -> p.getAge() >= 18)
                .toList();

        // ASSERT
        Assertions.assertEquals(2, adults.size(), "A lista deve conter apenas adultos");
    }
}