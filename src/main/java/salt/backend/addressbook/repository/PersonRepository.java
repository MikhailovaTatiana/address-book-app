package salt.backend.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salt.backend.addressbook.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
