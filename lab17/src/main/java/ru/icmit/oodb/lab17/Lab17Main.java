package ru.icmit.oodb.lab17;

import ru.icmit.oodb.lab17.domain.Bank;
import ru.icmit.oodb.lab17.domain.Client;

import javax.persistence.EntityManager;

public class Lab17Main {

    public static void main(String[] args) {
        DbWork db = DbWork.getInstance();
        EntityManager entityManager = db.getEmManager();
        entityManager.getTransaction().begin();

        Client client = new Client();
        client.setName("Клиент 1");

        Bank bank = new Bank();//entityManager.getReference(Bank.class, 1L);
        bank.setName("Первый");

        client.setBank(bank);
        
        entityManager.persist(client);

        System.out.println(client.getId());

        client.setName("Client 1");

        entityManager.getTransaction().commit();
        db.closeEntityManager();

        try {
            entityManager.merge(bank);
        } catch (Exception e) {
            e.printStackTrace();
        }

        entityManager = db.getEmManager();
        bank = entityManager.getReference(Bank.class, 1L);
        //System.out.println(bank.getName());


        entityManager.getTransaction().begin();
        bank.setName("Bank 22");
        entityManager.getTransaction().commit();



        db.closeEntityManager();

        DbWork.clear();
    }
}
