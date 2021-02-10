package ru.icmit.oodb.lab10;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.*;

import ru.icmit.oodb.lab10.domain.Bank;
import ru.icmit.oodb.lab10.domain.Client;

public class CreateDBTest {

    public static void main(String[] args) throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("lab10");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Bank bank = new Bank();
        bank.setName("Банк");
        bank.setBik("04900010002");
        bank.setId(3l);

        entityManager.persist(bank);

        Client client = new Client();
        client.setName("Клиент 1");
        client.setBank(bank);
        //client.setId(2l);
        entityManager.persist(client);

        transaction.commit();

        entityManager.close();

        entityManager = emf.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();

        client.setName("333333");

        client = entityManager.merge(client);

        transaction.commit();

        entityManager.close();
        emf.close();
    }
}
