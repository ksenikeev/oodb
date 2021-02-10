package ru.icmit.oodb.lab12.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name = "exchangerate",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"currency1_id","currency2_id", "dateRate"})}
)
public class ExchangeRate {

    @Id
    @SequenceGenerator(name="ExchangeRate", sequenceName="exchange_rate_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ExchangeRate")
    private Long id;

    @ManyToOne
    private Currency currency1;

    @ManyToOne
    private Currency currency2;

    private Double price;

    @Temporal(TemporalType.DATE)
    private Date dateRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getCurrency1() {
        return currency1;
    }

    public void setCurrency1(Currency currency1) {
        this.currency1 = currency1;
    }

    public Currency getCurrency2() {
        return currency2;
    }

    public void setCurrency2(Currency currency2) {
        this.currency2 = currency2;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDateRate() {
        return dateRate;
    }

    public void setDateRate(Date dateRate) {
        this.dateRate = dateRate;
    }
}
