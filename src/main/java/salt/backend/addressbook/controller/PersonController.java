package salt.backend.addressbook.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import salt.backend.addressbook.exception.PersonNotFoundException;
import salt.backend.addressbook.model.Person;
import salt.backend.addressbook.service.PersonService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    public PersonController(PersonService service) {
        this.personService = service;
    }

    @GetMapping
    public List<Person> persons() {
        return personService.findAllPersons();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Person createPerson(@Valid @RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable int id) throws PersonNotFoundException {
        return personService.getPersonById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/updatePerson/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable int id) {
        personService.updatePerson(person,id);
    }

    @GetMapping("/getPersonByName/{name}")
    public List<Person> getPersonByName(@PathVariable String name) {
        return personService.getPersonByFullName(name);
    }
}
