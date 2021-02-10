package ru.icmit.oodb.lab12.repository;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab12.domain.Bank;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class BankRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Bank> getBanks() {
        return entityManager.createQuery("select b from Bank b").getResultList();
    }



}
