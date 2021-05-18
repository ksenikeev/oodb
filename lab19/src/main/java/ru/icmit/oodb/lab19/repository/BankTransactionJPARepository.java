package ru.icmit.oodb.lab19.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.icmit.oodb.lab19.domain.BankTransaction;

@Repository
public interface BankTransactionJPARepository extends CrudRepository<BankTransaction, Long> {

}
