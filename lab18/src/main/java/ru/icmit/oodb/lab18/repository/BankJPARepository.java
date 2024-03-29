package ru.icmit.oodb.lab18.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.icmit.oodb.lab18.domain.Bank;
import ru.icmit.oodb.lab18.domain.Client;

@Repository
public interface BankJPARepository extends CrudRepository<Bank, Long> {

}
