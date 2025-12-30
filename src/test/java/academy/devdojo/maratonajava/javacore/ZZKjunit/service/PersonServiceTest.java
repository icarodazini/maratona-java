package academy.devdojo.maratonajava.javacore.ZZKjunit.service;

import academy.devdojo.maratonajava.javacore.ZZKjunit.dominio.Person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertFalse(personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equals than 18")
    void isAdult_ReturnTrue_WhenTheAgeIsGreaterOrEqualsThan18() {
        assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should return list with adult only")
    void isAdult_ThrowException_WhenPersonIsNull() {
        assertThrows(IllegalArgumentException.class
                , () -> personService.isAdult(null), "Person cannot be null");
    }

    @Test
    @DisplayName("Should throw NullPointerException with message when person is null")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        Person person1 = new Person(17);
        Person person2 = new Person(18);
        Person person3 = new Person(21);

        List<Person> personList = List.of(person1, person2, person3);

        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size());
    }
}