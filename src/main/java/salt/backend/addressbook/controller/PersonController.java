package salt.backend.addressbook.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import salt.backend.addressbook.model.Person;
import salt.backend.addressbook.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> persons() {
        return service.findAllPersons();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Person createPerson(@Valid @RequestBody Person person) {
        return service.savePerson(person);
    }
}
