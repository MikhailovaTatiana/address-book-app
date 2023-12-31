package salt.backend.addressbook.service;

import org.springframework.stereotype.Service;
import salt.backend.addressbook.model.Address;
import salt.backend.addressbook.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository ADDRESS_REPO;

    public AddressService(AddressRepository addressRepo) {
        ADDRESS_REPO = addressRepo;
    }

    public List<Address> findAllAddresses() {
        return ADDRESS_REPO.findAll();
    }

    public Address saveAddress(Address address) {
        return ADDRESS_REPO.save(address);
    }

    public Address getAddressById(int id) {
        return ADDRESS_REPO.getById(id);
    }

    public void deleteAddress(int id) {
        ADDRESS_REPO.deleteById(id);
    }
}
