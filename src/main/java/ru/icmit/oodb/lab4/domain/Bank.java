package ru.icmit.oodb.lab4.domain;

import java.util.List;

public class Bank {

    private String name;

    public static List<Worker> workers;

    public static List<Client> clients;

    public static List<Transaction> transactions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}