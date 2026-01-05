package academy.devdojo.maratonajava.javacore.ZZKjunit.service;

import academy.devdojo.maratonajava.javacore.ZZKjunit.dominio.Person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        adult = new Person(20);
        notAdult = new Person(16);
        personService = new PersonService();
    }

    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_ReturnFalse_WhanAgeLowerThan18() {
        // ARRANGE
        Person notAdult = new Person(15);

        // ACT
        boolean result = personService.isAdult(notAdult);

        // ASSERT
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equals than 18")
    void isAdult_ReturnTrue_WhenTheAgeIsGreaterOrEqualsThan18() {
        // ARRANGE
        Person adult = new Person(18);

        // ACT
        boolean result = personService.isAdult(adult);

        // ASSERT
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should return list with adult only")
    void isAdult_ThrowException_WhenPersonIsNull() {
        // ARRANGE
        Person person = null;

        // ACT & ASSERT (Em exceções, o JUnit captura a ação para validar)
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> personService.isAdult(person));

        // ASSERT (Validação extra da mensagem, se necessário)
        Assertions.assertEquals("Person cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw NullPointerException with message when person is null")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        // ARRANGE
        Person person1 = new Person(17);
        Person person2 = new Person(18);
        Person person3 = new Person(21);
        List<Person> personList = List.of(person1, person2, person3);

        // ACT
        List<Person> result = personService.filterRemovingNotAdult(personList);

        // ASSERT
        Assertions.assertEquals(2, result.size(), "A lista deveria conter apenas os 2 adultos");
    }
}