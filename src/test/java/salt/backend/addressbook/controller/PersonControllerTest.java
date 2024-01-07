package salt.backend.addressbook.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import salt.backend.addressbook.exception.PersonNotFoundException;
import salt.backend.addressbook.model.Person;
import salt.backend.addressbook.service.PersonService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void persons() {
        // Create a list of Person objects to be returned by the mock PersonService
        List<Person> expectedPersons = new ArrayList<>();

        Person person1 = new Person();
        person1.setId(1);
        person1.setFirstName("Anna");
        person1.setLastName("Star");
        person1.setPhone("08267483");
        person1.setEmail("anna@gmail.se");
        expectedPersons.add(person1);

        Person person2 = new Person();
        person2.setId(2);
        person2.setFirstName("Kim");
        person2.setLastName("Lee");
        person2.setPhone("+376289461");
        person2.setEmail("lee@yahoo.fi");
        expectedPersons.add(person2);

        // Set up the mock PersonService to return the expectedPersons list
        when(personService.findAllPersons()).thenReturn(expectedPersons);

        // Call the persons() method and assert the returned list is equal to the expectedPersons list
        List<Person> actualPersons = personController.persons();
        assertEquals(expectedPersons, actualPersons);
    }

    @Test
    void createPerson() {
        // Create a Person object to be saved
        Person personToSave = new Person();
        personToSave.setId(7);
        personToSave.setFirstName("Anna");
        personToSave.setLastName("Star");
        personToSave.setPhone("08267483");
        personToSave.setEmail("anna@gmail.se");

        // Create a Person object to be returned by the mock PersonService
        Person expectedPerson = new Person();
        personToSave.setId(7);
        expectedPerson.setFirstName("Anna");
        expectedPerson.setLastName("Star");
        expectedPerson.setPhone("08267483");
        expectedPerson.setEmail("anna@gmail.se");

        // Set up the mock PersonService to return the expectedPerson
        Mockito.when(personService.savePerson(personToSave)).thenReturn(expectedPerson);

        // Create an instance of the controller and inject the mock PersonService
        PersonController personController = new PersonController(personService);

        // Call the createPerson() method and assert the returned person is equal to the expectedPerson
        Person actualPerson = personController.createPerson(personToSave);
        assertEquals(expectedPerson, actualPerson);
    }

    @Test
    void getPerson()  throws PersonNotFoundException {
        // Create a Person object to be returned by the mock PersonService
        Person expectedPerson = new Person();
        expectedPerson.setId(1);
        expectedPerson.setFirstName("Anna");
        expectedPerson.setLastName("Star");
        expectedPerson.setPhone("08267483");
        expectedPerson.setEmail("anna@gmail.se");

        // Set up the mock PersonService to return the expectedPerson
        when(personService.getPersonById(1)).thenReturn(expectedPerson);

        // Call the getPerson() method with the ID 1 and assert the returned person is equal to the expectedPerson
        Person actualPerson = personController.getPerson(1);
        assertEquals(expectedPerson, actualPerson);
    }

    @Test
    void deletePerson() {
        // Call the deletePerson() method with the ID 1 and assert that no exceptions are thrown
        assertDoesNotThrow(() -> personController.deletePerson(1));
    }

    @Test
    void updatePerson() {
        // Create a Person object to be updated
        Person personToUpdate = new Person();
        personToUpdate.setId(1);
        personToUpdate.setFirstName("Anna");
        personToUpdate.setLastName("Star");
        personToUpdate.setPhone("08267483");
        personToUpdate.setEmail("anna@gmail.se");

        // Call the updatePerson() method with the personToUpdate object and the ID 1
        // and assert that no exceptions are thrown
        assertDoesNotThrow(() -> personController.updatePerson(personToUpdate, 1));
    }

    @Test
    void getPersonByName() {
        // Create a list of Person objects to be returned by the mock PersonService
        List<Person> expectedPersons = new ArrayList<>();

        Person person1 = new Person();
        person1.setId(1);
        person1.setFirstName("Anna");
        person1.setLastName("Star");
        person1.setPhone("08267483");
        person1.setEmail("anna@gmail.se");
        expectedPersons.add(person1);

        Person person2 = new Person();
        person2.setId(2);
        person2.setFirstName("Kim");
        person2.setLastName("Lee");
        person2.setPhone("+376289461");
        person2.setEmail("lee@yahoo.fi");
        expectedPersons.add(person2);

        // Set up the mock PersonService to return the expectedPersons list
        when(personService.getPersonByFullName("John")).thenReturn(expectedPersons);

        // Call the getPersonByName() method with the name "John" and assert the returned list is equal to the expectedPersons list
        List<Person> actualPersons = personController.getPersonByName("John");
        assertEquals(expectedPersons, actualPersons);
    }
}