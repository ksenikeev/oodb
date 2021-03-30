package ru.icmit.oodb.lab16.domain;

import javax.persistence.*;

@Entity
public class PersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personInfo")
    @SequenceGenerator(name = "personInfo", sequenceName = "personinfo_seq", allocationSize=1)
    private Long id;

    @OneToOne(mappedBy="personInfo")
    private Client client;

    private String phone;
    private String email;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
