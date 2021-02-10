package ru.icmit.oodb.test;

import java.util.Date;

public class Transaction {
    private String sourceaccount;
    private String destantionaccount;
    private int summ;
    private Date date;

    public String getSourceaccount() {
        return sourceaccount;
    }

    public void setSourceaccount(String sourceaccount) {
        this.sourceaccount = sourceaccount;
    }

    public String getDestantionaccount() {
        return destantionaccount;
    }

    public void setDestantionaccount(String destantionaccount) {
        this.destantionaccount = destantionaccount;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
