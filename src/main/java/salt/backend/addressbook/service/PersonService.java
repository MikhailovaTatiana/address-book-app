package salt.backend.addressbook.service;

import org.springframework.stereotype.Service;
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
}
