package salt.backend.addressbook.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String streetName;
        private String streetNumber;
        private String city;
        private String state;
        private String country;
        private int zipCode;
        @JsonManagedReference
        @OneToMany(mappedBy="address", fetch = FetchType.LAZY)
        private List<Person> persons;

        public Address() {
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getStreetName() {
                return streetName;
        }

        public void setStreetName(String streetName) {
                this.streetName = streetName;
        }

        public String getStreetNumber() {
                return streetNumber;
        }

        public void setStreetNumber(String streetNumber) {
                this.streetNumber = streetNumber;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public int getZipCode() {
                return zipCode;
        }

        public void setZipCode(int zipCode) {
                this.zipCode = zipCode;
        }

        public List<Person> getPersons() {
                return persons;
        }

        public void setPersons(List<Person> persons) {
                this.persons = persons;
        }

}
