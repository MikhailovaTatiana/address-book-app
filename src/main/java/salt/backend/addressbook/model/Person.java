package salt.backend.addressbook.model;

import jakarta.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;
        String firstName;
        String lastName;
        String phone;
        @Column(unique = true)
        String email;
        @ManyToOne
        @JoinColumn(name = "address_id")
        Address address;

        public Person() {
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Address getAddress() {
                return address;
        }

        public void setAddress(Address address) {
                this.address = address;
        }
}
