package salt.backend.addressbook.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import salt.backend.addressbook.model.Address;
import salt.backend.addressbook.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class AddressServiceTest {

    @Mock
    private AddressRepository ADDRESS_REPO;

    @InjectMocks
    private AddressService addressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllAddresses() {
        List<Address> addresses = new ArrayList<>();

        // Create test addresses and add them to the list
        Address address1 = new Address();
        address1.setStreetName("123 Main Street");
        address1.setCity("City1");
        address1.setState("State1");
        address1.setCountry("Country1");
        addresses.add(address1);

        Address address2 = new Address();
        address2.setStreetName("456 Elm Street");
        address2.setCity("City2");
        address2.setState("State2");
        address2.setCountry("Country2");
        addresses.add(address2);

        // Mock the repository method to return the test addresses
        when(ADDRESS_REPO.findAll()).thenReturn(addresses);

        // Call the service method
        List<Address> result = addressService.findAllAddresses();

        // Assert the result
        Assertions.assertEquals(addresses, result);
        verify(ADDRESS_REPO, times(1)).findAll();
    }

    @Test
    void saveAddress() {
        Address address = new Address();
        // Set test data for the address
        address.setStreetName("123 Test Street");
        address.setStreetNumber("456");
        address.setCity("Test City");
        address.setState("Test State");
        address.setCountry("Test Country");
        address.setZipCode(12345);

        when(ADDRESS_REPO.save(address)).thenReturn(address);

        Address result = addressService.saveAddress(address);

        Assertions.assertEquals(address, result);
        verify(ADDRESS_REPO, times(1)).save(address);
    }

    @Test
    void getAddressById() {
        int id = 1;
        Address address = new Address();
        // Set test data for the address
        address.setId(id);
        address.setStreetName("123 Test Street");
        address.setStreetNumber("456");
        address.setCity("Test City");
        address.setState("Test State");
        address.setCountry("Test Country");
        address.setZipCode(12345);

        when(ADDRESS_REPO.getById(id)).thenReturn(address);

        Address result = addressService.getAddressById(id);

        Assertions.assertEquals(address, result);
        verify(ADDRESS_REPO, times(1)).getById(id);
    }

    @Test
    void deleteAddress() {
        int id = 1;

        addressService.deleteAddress(id);

        verify(ADDRESS_REPO, times(1)).deleteById(id);
    }

    @Test
    void updateAddress() {
        int id = 1;
        Address address = new Address();
        // Set test data for the address
        address.setId(id);
        address.setStreetName("123 Test Street");
        address.setStreetNumber("456");
        address.setCity("Test City");
        address.setState("Test State");
        address.setCountry("Test Country");
        address.setZipCode(12345);

        Address existingAddress = new Address();
        // Set test data for the existing address
        address.setStreetName("456 Test Avenue");
        address.setStreetNumber("377");
        address.setCity("NY");
        address.setState("Florida");
        address.setCountry("Canada");
        address.setZipCode(54321);

        when(ADDRESS_REPO.getById(id)).thenReturn(existingAddress);
        when(ADDRESS_REPO.save(existingAddress)).thenReturn(existingAddress);

        addressService.updateAddress(address, id);

        Assertions.assertEquals(address.getStreetName(), existingAddress.getStreetName());
        Assertions.assertEquals(address.getStreetNumber(), existingAddress.getStreetNumber());
        Assertions.assertEquals(address.getCity(), existingAddress.getCity());
        Assertions.assertEquals(address.getState(), existingAddress.getState());
        Assertions.assertEquals(address.getCountry(), existingAddress.getCountry());
        Assertions.assertEquals(address.getZipCode(), existingAddress.getZipCode());

        verify(ADDRESS_REPO, times(1)).getById(id);
        verify(ADDRESS_REPO, times(1)).save(existingAddress);
    }

    @Test
    void getAddressByStreetNameAndStreetNumber() {
        String street = "Sample Street";
        List<Address> addresses = new ArrayList<>();

        // Add test addresses to the list
        Address address1 = new Address();
        address1.setStreetName("Sample Street");
        address1.setCity("City1");
        address1.setState("State1");
        address1.setCountry("Country1");
        addresses.add(address1);

        Address address2 = new Address();
        address2.setStreetName("Sample Street");
        address2.setCity("City2");
        address2.setState("State2");
        address2.setCountry("Country2");
        addresses.add(address2);

        when(ADDRESS_REPO.findAllAddressesByStreet(street)).thenReturn(addresses);

        List<Address> result = addressService.getAddressByStreetNameAndStreetNumber(street);

        Assertions.assertEquals(addresses, result);
        verify(ADDRESS_REPO, times(1)).findAllAddressesByStreet(street);
    }
}