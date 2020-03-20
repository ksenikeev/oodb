package domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccountTransaction {
    @Id
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @ManyToOne
    private Account sourceAccount;

    @ManyToOne
    private Account destantionAccount;

    private Double transationSum;

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

    public Double getTransationSum() {
        return transationSum;
    }

    public void setTransationSum(Double transationSum) {
        this.transationSum = transationSum;
    }
}
