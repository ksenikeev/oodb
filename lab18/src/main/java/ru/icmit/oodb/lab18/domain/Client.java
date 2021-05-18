package ru.icmit.oodb.lab18.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client")
    @SequenceGenerator(name = "client", sequenceName = "client_seq", allocationSize=1)
    private Long id;

    @Version
    protected long version;

    private String name;

    //@JoinColumn(name="bank_fk")
    @ManyToOne(cascade = CascadeType.ALL)
    private Bank bank;

    //@JoinColumn(name = "person_info")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.ALL})
    //@JoinColumn
    private PersonInfo personInfo;

    @ManyToMany
    @JoinColumn(name = "client_id")
    private Collection<BankAccount> accounts;

    @ManyToMany
    @JoinTable(name = "addressofclient")
    private List<Address> addresses;

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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public long getVersion() {
        return version;
    }

    public Collection<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<BankAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name);
    }
}
