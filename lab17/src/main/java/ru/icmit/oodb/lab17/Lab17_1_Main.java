package ru.icmit.oodb.lab17;

import ru.icmit.oodb.lab17.domain.Bank;
import ru.icmit.oodb.lab17.domain.Client;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.*;

public class Lab17_1_Main {

    public static void main(String[] args) {
        DbWork db = DbWork.getInstance();

        EntityManager entityManager = db.getEmManager();
        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 15L);
        System.out.println(Thread.currentThread().getId() + ", version = "
                + client.getVersion() + ", em " + entityManager.hashCode());

        long v1 = client.getVersion();

        Thread thread2 = new Thread(new Task2());
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Query query = entityManager.createQuery("select c.version from Client c where c.id = :id");
        query.setParameter("id", 15l);


        client.setName("Client 1 task 1");

        Long v2 = (Long) query.getSingleResult();
        System.out.println("v2 = " + v2);
        try {
            if (v1==v2)
                entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        db.closeEntityManager();


        DbWork.clear();
    }
}
