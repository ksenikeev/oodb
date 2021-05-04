package ru.icmit.oodb.lab18.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BankEntityManagerRepository {

    @PersistenceContext
    private EntityManager entityManager;

}
