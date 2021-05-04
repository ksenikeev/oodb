package ru.icmit.oodb.lab18.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.icmit.oodb.lab18.domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClientEntityManagerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateClientName(Client client, String newName) {
        return entityManager.createQuery("UPDATE Client c SET c.name = :name WHERE c = :c ")
                .setParameter("c", client).setParameter("name", newName).executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteClient(Client client) {
        return entityManager.createQuery("DELETE FROM Client c  WHERE c = :c ")
                .setParameter("c", client).executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteManyClient(List<Client> clients) {
        return entityManager.createQuery("DELETE FROM Client c  WHERE c IN :list ")
                .setParameter("list", clients).executeUpdate();
    }

}
