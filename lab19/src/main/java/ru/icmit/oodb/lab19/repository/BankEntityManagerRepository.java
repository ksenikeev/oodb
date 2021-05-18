package ru.icmit.oodb.lab19.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BankEntityManagerRepository {

    @PersistenceContext
    private EntityManager entityManager;

}
