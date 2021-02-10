package ru.icmit.oodb.lab12.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "dict_currency")
public class Currency {

    @Id
    private Long id;

    private String nCode;

    private String code;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnCode() {
        return nCode;
    }

    public void setnCode(String nCode) {
        this.nCode = nCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
