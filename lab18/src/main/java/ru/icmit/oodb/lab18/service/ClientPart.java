package ru.icmit.oodb.lab18.service;

public class ClientPart {

    private Long id;
    private String name;

    public ClientPart(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientPart() {
    }

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
}
