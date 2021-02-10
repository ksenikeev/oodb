package ru.icmit.oodb.lab6.domain;

import ru.icmit.oodb.lab6.annotation.Column;
import ru.icmit.oodb.lab6.annotation.Entity;
import ru.icmit.oodb.lab6.annotation.OneToMany;

import java.util.List;

@Entity
public class Bank {

    @Column
    private String name;

    @Column
    @OneToMany
    public static List<Worker> workers;

    @Column
    @OneToMany
    public static List<Client> clients;

    @Column
    @OneToMany
    public static List<Transaction> transactions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}