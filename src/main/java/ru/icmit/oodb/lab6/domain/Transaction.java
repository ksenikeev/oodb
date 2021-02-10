package ru.icmit.oodb.lab6.domain;

import ru.icmit.oodb.lab6.annotation.Column;
import ru.icmit.oodb.lab6.annotation.Entity;

import java.util.Date;

@Entity
public class Transaction {

    @Column
    private BankAccount bancAccount;

    @Column
    private Worker worker;

    @Column
    private Date transactionDate;

    @Column
    private Client client;

    @Column
    private double amount;

    public Transaction(BankAccount bancAccount, Worker worker, Client client, double amount) {
        this.bancAccount = bancAccount;
        this.worker = worker;
        this.transactionDate = new Date();
        this.client = client;
        this.amount = amount;
        if (amount > 0) {
            increaseBalance(amount);
        } else {
            reduceBalance(amount);
        }
    }

    private void increaseBalance(double amount) {
        bancAccount.increaseBalance(amount);
    }

    private boolean reduceBalance(double amount) {
        return bancAccount.reduceBalance(amount);
    }

    public BankAccount getBancAccount() {
        return bancAccount;
    }

    public void setBancAccount(BankAccount bancAccount) {
        this.bancAccount = bancAccount;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
