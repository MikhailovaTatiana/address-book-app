package salt.backend.addressbook.service;

import org.springframework.stereotype.Service;
import salt.backend.addressbook.model.Address;
import salt.backend.addressbook.model.Person;
import salt.backend.addressbook.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository PERSON_REPO;

    public PersonService(PersonRepository personRepository) {
        this.PERSON_REPO = personRepository;
    }

    public List<Person> findAllPersons() {
        return PERSON_REPO.findAll();
    }

    public Person savePerson(Person person) {
        return PERSON_REPO.save(person);
    }

    public Person getPersonById(int id) {
        return PERSON_REPO.getById(id);
    }

    public void deletePerson(int id) {
        PERSON_REPO.deleteById(id);
    }

    public void updatePerson(Person person, int id) {
        Person personIn = getPersonById(id);
        personIn.setFirstName(person.getFirstName());
        personIn.setLastName(person.getLastName());
        personIn.setPhone(person.getPhone());
        personIn.setEmail(person.getEmail());
        savePerson(personIn);
    }
}
