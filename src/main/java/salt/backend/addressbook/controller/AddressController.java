package salt.backend.addressbook.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import salt.backend.addressbook.model.Address;
import salt.backend.addressbook.model.Person;
import salt.backend.addressbook.service.AddressService;
import salt.backend.addressbook.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public List<Address> addresses() {
        return service.findAllAddresses();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Address createAddress(@Valid @RequestBody Address address) {
        return service.saveAddress(address);
    }
}
