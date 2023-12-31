package salt.backend.addressbook.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import salt.backend.addressbook.exception.AddressNotFoundException;
import salt.backend.addressbook.model.Address;
import salt.backend.addressbook.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    public AddressController(AddressService service) {
        this.addressService = service;
    }

    @GetMapping
    public List<Address> addresses() {
        return addressService.findAllAddresses();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @GetMapping("/getAddress/{id}")
    public Address getAddress(@PathVariable int id) throws AddressNotFoundException {
        return addressService.getAddressById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteAddress/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
    }
}
