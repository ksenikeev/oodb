package ru.icmit.oodb.lab14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.icmit.oodb.lab14.domain.Client;
import ru.icmit.oodb.lab14.domain.PersonInfo;
import java.util.List;

@Controller
@RequestMapping
public class OneToOneController {

    @Autowired
    private ClientRepository repository;

    @GetMapping(value = "/add")
    @ResponseBody
    public String oto() {

        Client client = new Client();
        client.setName("Клиент 1");

        PersonInfo personInfo =  new PersonInfo();
        personInfo.setPhone("11111");
        personInfo.setEmail("email");

        client.setPersonInfo(personInfo);

        //repository.save(personInfo);
        repository.save(client);

        return "Client added!";
    }

    @GetMapping(value = "/remove")
    @ResponseBody
    public String otoB3() {
        Client client = repository.find(2l);
        repository.remove(client);
        return "Deleted";
    }
}
