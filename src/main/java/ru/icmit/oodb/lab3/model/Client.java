package ru.icmit.oodb.lab3.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Client extends Person {

    public Client(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public Client() {
    }

    private List<BankAccount> accounts;


    @XmlElementWrapper(name = "accounts")
    @XmlElement(name = "account")
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
