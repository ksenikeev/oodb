package ru.icmit.oodb.lab8.domain;

import ru.icmit.oodb.lab8.annotation.Column;
import ru.icmit.oodb.lab8.annotation.Entity;
import ru.icmit.oodb.lab8.annotation.Id;

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