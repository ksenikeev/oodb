package ru.icmit.oodb.lab16;

import ru.icmit.oodb.lab16.domain.Client;

import javax.persistence.EntityManager;

public class Lab16Main {

    public static void main(String[] args) {
        DbWork db = DbWork.getInstance();

        Client client = new Client();
        client.setName("Клиент 1");

        EntityManager entityManager = db.getEmManager();
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        db.closeEntityManager();

        DbWork.clear();
    }
}
