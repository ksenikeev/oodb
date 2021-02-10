package ru.icmit.oodb.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Bank {

    private String name;

    private String inn;

    private String bik;

    private String address;

    private List<CLient> cLients;

    private List<Transaction> transactions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElementWrapper(name = "clients")
    @XmlElement(name = "client")
    public List<CLient> getcLients() {
        return cLients;
    }

    public void setcLients(List<CLient> cLients) {
        this.cLients = cLients;
    }

    @XmlElementWrapper(name = "transactions")
    @XmlElement(name = "transaction")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
