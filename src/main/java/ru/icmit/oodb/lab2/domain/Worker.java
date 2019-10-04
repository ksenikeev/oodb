package ru.icmit.oodb.lab2.domain;

public class Worker extends Person {
    private Long id;
    private String position;
    private String code;

    public Worker(String firstName, String lastName, String phoneNumber, String email, String position, String code) {
        super(firstName, lastName, phoneNumber, email);
        this.position = position;
        this.code = code;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
