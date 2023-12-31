package salt.backend.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salt.backend.addressbook.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
