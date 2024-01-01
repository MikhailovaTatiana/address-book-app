package salt.backend.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import salt.backend.addressbook.model.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

//    @Query("SELECT a FROM Address a WHERE a.streetName = ?1")
    @Query("SELECT a FROM Address a WHERE CONCAT(a.streetName, ' ', a.streetNumber) LIKE %?1%")
    List<Address> findAllByStreet(String streetName);
}
