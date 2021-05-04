package ru.icmit.oodb.lab18.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.icmit.oodb.lab18.domain.Bank;
import ru.icmit.oodb.lab18.domain.Client;

import java.util.List;

@Repository
public interface ClientJPARepository extends CrudRepository<Client, Long> {

    @Query("SELECT DISTINCT c FROM Client c WHERE c.bank.id = 1")
    List<Client> selectDistinct();
}
