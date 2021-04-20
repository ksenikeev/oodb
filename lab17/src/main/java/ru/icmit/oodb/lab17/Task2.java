package ru.icmit.oodb.lab17;

import ru.icmit.oodb.lab17.domain.Client;

import javax.persistence.EntityManager;

public class Task2 implements Runnable {

    @Override
    public void run() {
        DbWork db = DbWork.getInstance();

        EntityManager entityManager = db.getEmManager();
        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 15L);
        System.out.println(Thread.currentThread().getId() + ", version = " +
                client.getVersion() + ", em " + entityManager.hashCode());
        client.setName("Client 1 task 2");

        entityManager.getTransaction().commit();
        db.closeEntityManager();

    }

}
