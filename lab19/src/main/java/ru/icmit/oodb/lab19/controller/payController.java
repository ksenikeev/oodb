package ru.icmit.oodb.lab19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.icmit.oodb.lab19.domain.BankTransaction;
import ru.icmit.oodb.lab19.domain.Organization;
import ru.icmit.oodb.lab19.domain.Users;
import ru.icmit.oodb.lab19.service.BankService;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class payController {

    @Autowired
    private BankService service;

    @GetMapping(value="/paypage")
    @ResponseBody
    public String payPage(HttpServletRequest request,
                            @RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {

        Users user = (Users) request.getSession(false).getAttribute("user");

        return "<html><body>" +
                    "<h1>Add pay</h1>" +
                    "<form method='post' action='/addpay'>" +
                    "Organization source (id):<input name='org1' type='text'/><br/>" +
                    "Organization destantion (id):<input name='org2' type='text'/><br/>" +
                    "Summ:<input name='summ' type='text'/><br/>" +
                    "<input type='submit'/>" +
                    "<form>" +
                    "</body></html>";
    }

    @PostMapping(value="/addpay")
    @ResponseBody
    public String pay(HttpServletRequest request,
                          @RequestParam(name = "org1") Long org1, @RequestParam(name = "org2") Long org2,
                       @RequestParam(name = "summ") Double summ) {

        Users user = (Users) request.getSession(false).getAttribute("user");

        BankTransaction transaction = new BankTransaction();
        transaction.setUser(user);
        transaction.setBank1(user.getBank());
        transaction.setOrg1(service.getReference(org1));

        Organization organization2 = service.getOrganization(org2);

        transaction.setOrg2(organization2);
        transaction.setBank2(organization2.getBank());
        transaction.setSumm(summ);
        transaction.setTrdate(new Date());

        service.save(transaction);

        return "<html><body>" +
                "<h1>Pay added! Add new pay</h1>" +
                "<form method='post' action='/addpay'>" +
                "Organization source (id):<input name='org1' type='text'/><br/>" +
                "Organization destantion (id):<input name='org2' type='text'/><br/>" +
                "Summ:<input name='summ' type='text'/><br/>" +
                "<input type='submit'/>" +
                "<form>" +
                "</body></html>";
    }
}
