package ru.icmit.oodb.lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.icmit.oodb.lab12.domain.Bank;
import ru.icmit.oodb.lab12.repository.BankRepository;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BankRepository repository;

    @GetMapping(value = "/bank")
    @ResponseBody
    public List<Bank> getBanks() {
        return repository.getBanks();
    }
}
