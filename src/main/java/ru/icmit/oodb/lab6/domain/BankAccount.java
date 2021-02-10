package ru.icmit.oodb.lab6.domain;

import ru.icmit.oodb.lab6.annotation.Column;
import ru.icmit.oodb.lab6.annotation.Entity;

@Entity
class BankAccount {

    public static long currentAccountNumber = 1000000000000000L;

    @Column
    private long accountNumber;

    @Column
    private double balance;

    BankAccount(long accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    long getAccountNumber() {
        return accountNumber;
    }

    double getBalance() {
        return balance;
    }

    protected void increaseBalance(double cash) {
        this.balance += cash;
    }

    protected boolean reduceBalance(double cash) {
        if (balance < cash) {
            return false;
        } else {
            this.balance -= cash;
            return true;
        }
    }
}