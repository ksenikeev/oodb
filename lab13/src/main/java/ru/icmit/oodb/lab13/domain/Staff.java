package ru.icmit.oodb.lab13.domain;

import javax.persistence.*;

@Entity
public class Staff extends Person {

/*
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff")
    @SequenceGenerator(name = "staff", sequenceName = "staff_seq", allocationSize=1)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
*/

    private String staffPosition;

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }
}
