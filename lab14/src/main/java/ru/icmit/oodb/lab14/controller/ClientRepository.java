package ru.icmit.oodb.lab14.controller;

import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab14.domain.Client;
import ru.icmit.oodb.lab14.domain.PersonInfo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Client client) {
        entityManager.persist(client);
    }

    @Transactional
    public void save(PersonInfo personInfo) {
        entityManager.persist(personInfo);
    }

    public List<Client> getClients() {
        return entityManager.createQuery("select c from Client c").getResultList();
    }

    public List<PersonInfo> getInfos() {
        return entityManager.createQuery("select p from PersonInfo p").getResultList();
    }
}
