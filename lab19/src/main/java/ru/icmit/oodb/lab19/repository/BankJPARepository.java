package ru.icmit.oodb.lab19.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.icmit.oodb.lab19.domain.Bank;

@Repository
public interface BankJPARepository extends CrudRepository<Bank, Long> {

}
