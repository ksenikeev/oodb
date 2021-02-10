package ru.icmit.oodb.lab12.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {

    @Id
    @SequenceGenerator(name="Account", sequenceName="account_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Account")
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Bank bank;

    @Column(length=20)
    private String accountNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date closeDate;

    @ManyToOne
    private Currency currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}