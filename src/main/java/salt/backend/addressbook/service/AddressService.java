package salt.backend.addressbook.service;

import org.springframework.stereotype.Service;
import salt.backend.addressbook.model.Address;
import salt.backend.addressbook.repository.AddressRepository;
;
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

    public void updateAddress(Address address, int id) {
        Address addressIn = getAddressById(id);
        addressIn.setStreetName(address.getStreetName());
        addressIn.setStreetNumber(address.getStreetNumber());
        addressIn.setCity(address.getCity());
        addressIn.setState(address.getState());
        addressIn.setCountry(address.getCountry());
        addressIn.setZipCode(address.getZipCode());
        saveAddress(addressIn);
    }

    public List<Address> getAddressByStreet(String street) {
        return ADDRESS_REPO.findAllByStreet(street);
    }
}
