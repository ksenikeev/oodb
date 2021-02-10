package ru.icmit.oodb.lab5.model;

import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person extends PGobject {

    private String firstname;
    private String lastname;
    private String middlename;
    private String gender;
    private Date birthdate;

    public Person() {
        setType("person");
    }

    public void setValue(String value) throws SQLException {
        String s = value.substring(1, value.length()-1);
        PGtokenizer t = new PGtokenizer(s, ',');
        if(t.getSize() != 2) throw new SQLException("Failed to convert to type Person");
        firstname = t.getToken(0);
        lastname = t.getToken(1);
        middlename = t.getToken(2);
        gender = t.getToken(3);
        try {
            birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(t.getToken(4));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getValue() {
        return "('" + firstname + "','" + lastname + "','" + middlename + "','" + gender
                + "','" + new SimpleDateFormat("yyyy-MM-dd").format(birthdate) + "')";
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
