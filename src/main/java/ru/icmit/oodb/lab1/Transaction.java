package ru.icmit.oodb.lab1;

import java.util.Date;

public class Transaction {

    private BankAccount bankAccount;

    private Date transactionDate;

    private Client client;

    private double amount;

    public Transaction(BankAccount bankAccount, Client client, double amount) {
        this.bankAccount = bankAccount;
        this.transactionDate = new Date();
        this.client = client;
        this.amount = amount;
        if (amount > 0) {
            increaseBalance(amount);
        } else {
            reduceBalance(amount);
        }
    }

    public Transaction() {
    }

    private void increaseBalance(double amount) {
        bankAccount.increaseBalance(amount);
    }

    private boolean reduceBalance(double amount) {
        return bankAccount.reduceBalance(amount);
    }

    public BankAccount getBancAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bancAccount) {
        this.bankAccount = bankAccount;
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
