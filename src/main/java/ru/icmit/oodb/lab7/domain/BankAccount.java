package ru.icmit.oodb.lab7.domain;

import ru.icmit.oodb.lab6.annotation.Column;
import ru.icmit.oodb.lab6.annotation.Entity;
import ru.icmit.oodb.lab7.annotation.Id;

@Entity
class BankAccount {

    @Id
    private Long id;

    @Column
    private Bank bank;

    @Column
    private Long accountNumber;

    @Column
    private Double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}