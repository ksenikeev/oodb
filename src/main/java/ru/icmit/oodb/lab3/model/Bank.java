package ru.icmit.oodb.lab3.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "bank")
public class Bank {

    private String name;

    private List<Client> clients;

    private List<Transaction> transactions;

    private List<BankAccount> bankAccounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "clients")
    @XmlElement(name = "client")
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @XmlElementWrapper(name = "transactions")
    @XmlElement(name = "transaction")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @XmlElementWrapper(name = "bankAccounts")
    @XmlElement(name = "bankAccount")
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return "Bank: " +
                "name='" + name + '\n' +
                ", clients=" + clients + '\n' +
                ", transactions=" + transactions + '\n' +
                ", bankAccounts=" + bankAccounts;
    }
}