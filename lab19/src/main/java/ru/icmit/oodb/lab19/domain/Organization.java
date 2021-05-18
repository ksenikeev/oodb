package ru.icmit.oodb.lab19.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Organization {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    private Bank bank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
