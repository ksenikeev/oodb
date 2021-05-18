package ru.icmit.oodb.lab18.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.icmit.oodb.lab18.domain.Bank;
import ru.icmit.oodb.lab18.domain.Client;
import ru.icmit.oodb.lab18.service.ClientPart;

import java.util.List;

@Repository
public interface ClientJPARepository extends CrudRepository<Client, Long> {

    @Query("SELECT c FROM Client AS c WHERE c.bank.id = 1")
    List<Client> selectDistinct();

    @Query("SELECT new ru.icmit.oodb.lab18.service.ClientPart(c.id, c.name) FROM Client c WHERE c.bank.id = 1")
    List<ClientPart> selectPart();

    @Query("SELECT c FROM Client c JOIN FETCH c.accounts")
    List<Client> selectClientAccount();

    @Query("SELECT c FROM Client c JOIN c.bank where c.bank = :bank ")
    List<Client> selectBankClients(@Param("bank") Bank bank);

}
