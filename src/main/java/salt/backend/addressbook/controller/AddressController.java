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
@CrossOrigin(origins = "http://localhost:8080")
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
    public Address getAddressById(@PathVariable int id) throws AddressNotFoundException {
        return addressService.getAddressById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteAddress/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/updateAddress/{id}")
    public void updateAddress(@RequestBody Address address, @PathVariable int id) {
        addressService.updateAddress(address, id);
    }

    @GetMapping("/getAddressByStreet/{street}")
    public List<Address> getAddressByStreet(@PathVariable String street) {
        return addressService.getAddressByStreetNameAndStreetNumber(street);
    }
}
