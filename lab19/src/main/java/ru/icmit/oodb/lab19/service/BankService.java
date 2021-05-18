package ru.icmit.oodb.lab19.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab19.domain.BankTransaction;
import ru.icmit.oodb.lab19.domain.Organization;
import ru.icmit.oodb.lab19.repository.BankJPARepository;
import ru.icmit.oodb.lab19.repository.BankTransactionJPARepository;
import ru.icmit.oodb.lab19.repository.OrganizationJPARepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class BankService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BankJPARepository bankJPARepository;

    @Autowired
    private BankTransactionJPARepository bankTransactionJPARepository;

    @Autowired
    private OrganizationJPARepository organizationJPARepository;

    @Transactional
    public void save(BankTransaction transaction) {
        bankTransactionJPARepository.save(transaction);
    }

    public Organization getReference(Long id) {
        return entityManager.getReference(Organization.class, id);
    }

    public Organization getOrganization(Long id) {
        return organizationJPARepository.getOrganization(id);
    }

}
