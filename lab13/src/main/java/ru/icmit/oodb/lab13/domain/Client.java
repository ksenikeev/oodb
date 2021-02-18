package ru.icmit.oodb.lab13.domain;

import javax.persistence.*;

@Entity
public class Client extends Person {

/*
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client")
    @SequenceGenerator(name = "client", sequenceName = "client_seq", allocationSize=1)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
*/

    private String passport;

    private String address;

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
