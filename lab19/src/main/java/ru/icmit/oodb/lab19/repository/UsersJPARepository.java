package ru.icmit.oodb.lab19.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.icmit.oodb.lab19.domain.Users;

@Repository
public interface UsersJPARepository extends CrudRepository<Users, Long> {

    @Query("select u from Users u where login = :login and password = :password")
    Users getUser(@Param("login") String login, @Param("password") String password);
}
