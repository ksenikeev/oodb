package ru.icmit.oodb.lab19.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banktr")
    @SequenceGenerator(name = "banktr", sequenceName = "banktr_seq", allocationSize=1)
    private Long id;

    @ManyToOne
    private Organization org1;

    @ManyToOne
    private Organization org2;

    @ManyToOne
    private Bank bank2;

    @ManyToOne
    private Bank bank1;

    private Double summ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date trdate;

    @ManyToOne
    private Users user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getOrg1() {
        return org1;
    }

    public void setOrg1(Organization org1) {
        this.org1 = org1;
    }

    public Organization getOrg2() {
        return org2;
    }

    public void setOrg2(Organization org2) {
        this.org2 = org2;
    }

    public Bank getBank2() {
        return bank2;
    }

    public void setBank2(Bank bank2) {
        this.bank2 = bank2;
    }

    public Bank getBank1() {
        return bank1;
    }

    public void setBank1(Bank bank1) {
        this.bank1 = bank1;
    }

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
