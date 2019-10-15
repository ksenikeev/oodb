package ru.icmit.oodb.lab1;

import java.util.List;

public class Client extends Person {

    public Client(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public Client() {
    }

    private List<BankAccount> accounts;

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client: " + getLastName() +
                ", accounts=" + accounts +
                '\n';
    }
}
