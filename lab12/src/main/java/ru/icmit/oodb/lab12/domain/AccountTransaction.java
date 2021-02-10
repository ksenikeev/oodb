package ru.icmit.oodb.lab12.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccountTransaction{

    @Id
    @SequenceGenerator(name="AccountTransaction", sequenceName="account_transaction_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="AccountTransaction")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @ManyToOne
    private Account sourceAccount;

    @ManyToOne
    private Account destantionAccount;

    private Double transationSumSrc;

    private Double transationSumDst;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestantionAccount() {
        return destantionAccount;
    }

    public void setDestantionAccount(Account destantionAccount) {
        this.destantionAccount = destantionAccount;
    }

    public Double getTransationSumSrc() {
        return transationSumSrc;
    }

    public void setTransationSumSrc(Double transationSumSrc) {
        this.transationSumSrc = transationSumSrc;
    }

    public Double getTransationSumDst() {
        return transationSumDst;
    }

    public void setTransationSumDst(Double transationSumDst) {
        this.transationSumDst = transationSumDst;
    }
}