package ru.icmit.oodb.lab9;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateDBTest {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("lab9");
        emf.close();
    }
}
