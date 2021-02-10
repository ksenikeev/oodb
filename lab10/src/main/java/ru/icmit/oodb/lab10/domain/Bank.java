package ru.icmit.oodb.lab10.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {

    @Id
    private Long id;

    private String name;

    private String bik;

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

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }
}