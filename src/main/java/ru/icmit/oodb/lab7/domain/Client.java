package ru.icmit.oodb.lab7.domain;

import ru.icmit.oodb.lab6.annotation.Column;
import ru.icmit.oodb.lab6.annotation.Entity;
import ru.icmit.oodb.lab6.annotation.OneToMany;
import ru.icmit.oodb.lab7.annotation.Id;
import ru.icmit.oodb.lab7.annotation.ManyToOne;

import java.util.List;

@Entity
public class Client extends Person {

    @Id
    private Long id;

    @Column
    @ManyToOne
    private Bank bank;

    @Column
    @OneToMany
    private List<BankAccount> bankAccounts;

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

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
