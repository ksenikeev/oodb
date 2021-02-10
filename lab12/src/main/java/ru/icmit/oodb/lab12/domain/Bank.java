package ru.icmit.oodb.lab12.domain;

import javax.persistence.*;

@Entity
public class Bank {

    @Id
    @SequenceGenerator(name="bank", sequenceName="bank_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="bank")
    private Long id;

    private String name;

    private String bik;

    private String kpp;

    private String bankAccount;

    private String systemId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}