package ru.icmit.oodb.lab13.domain;


import javax.persistence.*;

//@MappedSuperclass
//@Entity@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Entity@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends AbstractEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person")
    @SequenceGenerator(name = "person", sequenceName = "person_seq", allocationSize=1)
    private Long id;

    private String name;

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
