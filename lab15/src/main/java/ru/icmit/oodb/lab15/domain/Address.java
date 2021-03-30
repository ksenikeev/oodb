package ru.icmit.oodb.lab15.domain;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address")
    @SequenceGenerator(name = "address", sequenceName = "address_seq", allocationSize=1)
    private Long id;

    private String adr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }
}
