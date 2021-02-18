package ru.icmit.oodb.lab13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.icmit.oodb.lab13.domain.Client;
import ru.icmit.oodb.lab13.domain.Person;
import ru.icmit.oodb.lab13.domain.Staff;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class IndexController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(value = "/")
    @ResponseBody
    @Transactional
    public List<Client> getBanks() {

        Client client = new Client();
        client.setName("Клиент 1");
        client.setAddress("Казань");
        client.setPassport("1111111");
        entityManager.persist(client);

        Staff staff = new Staff();
        staff.setName("Персонал 1");
        staff.setStaffPosition("Кассир");
        entityManager.persist(staff);

        Person person = new Person();
        person.setName("Человек");
        entityManager.persist(person);

        return entityManager.createQuery("select c from Person c").getResultList();
    }
}
