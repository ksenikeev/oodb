package ru.icmit.oodb.lab15.domain;

import javax.persistence.*;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account")
    @SequenceGenerator(name = "account", sequenceName = "account_seq", allocationSize=1)
    private Long id;

    private String account;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

/*
    private String opendata;
    public String getOpendata() {
        return opendata;
    }
    public void setOpendata(String opendata) {
        this.opendata = opendata;
    }
*/
}
