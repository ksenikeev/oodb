package ru.icmit.oodb.lab6.domain;

import java.util.List;

public class Client extends Person {

    private List<BankAccount> bankAccounts;

    public Client(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public long createBankAccount() {
        long newAccountNumber = BankAccount.currentAccountNumber++;

        bankAccounts.add(new BankAccount(newAccountNumber));

        return newAccountNumber;
    }

    private BankAccount findBankAccount(long accountNumber) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                return bankAccount;
            }
        }

        return null;
    }
}
