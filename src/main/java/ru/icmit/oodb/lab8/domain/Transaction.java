package ru.icmit.oodb.lab8.domain;

import ru.icmit.oodb.lab6.annotation.Column;
import ru.icmit.oodb.lab6.annotation.Entity;
import ru.icmit.oodb.lab8.annotation.Id;

import java.util.Date;

@Entity
public class Transaction {

    @Id
    private Long id;

    @Column
    private BankAccount bancAccount;

    @Column
    private Worker worker;

    @Column
    private Date transactionDate;

    @Column
    private Client client;

    @Column
    private Double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
