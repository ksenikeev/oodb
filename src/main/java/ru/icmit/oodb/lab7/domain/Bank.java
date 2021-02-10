package ru.icmit.oodb.lab7.domain;

import ru.icmit.oodb.lab6.annotation.Column;
import ru.icmit.oodb.lab6.annotation.Entity;
import ru.icmit.oodb.lab6.annotation.OneToMany;
import ru.icmit.oodb.lab7.annotation.Id;

import java.util.List;

@Entity
public class Bank {

    @Id
    private Long id;

    @Column
    private String name;

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
}