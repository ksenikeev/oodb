package ru.icmit.oodb.lab1;

import java.util.List;

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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

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