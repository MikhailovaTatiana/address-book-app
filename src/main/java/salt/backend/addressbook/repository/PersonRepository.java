package salt.backend.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import salt.backend.addressbook.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    //    @Query("SELECT p FROM Person p WHERE p.lastName = ?1")
    @Query("SELECT p FROM Person p WHERE CONCAT(p.firstName, ' ', p.lastName) LIKE %?1%")
    List<Person> findAllPersonsByName(String name);
}
