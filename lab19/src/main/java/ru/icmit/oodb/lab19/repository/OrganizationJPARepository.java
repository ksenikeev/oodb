package ru.icmit.oodb.lab19.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.icmit.oodb.lab19.domain.Organization;

@Repository
public interface OrganizationJPARepository extends CrudRepository<Organization, Long> {

    @Query("select o from Organization o where id = :id ")
    Organization getOrganization(@Param("id") Long id);
}
