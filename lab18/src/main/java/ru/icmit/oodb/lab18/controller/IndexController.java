package ru.icmit.oodb.lab18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.icmit.oodb.lab18.domain.Client;
import ru.icmit.oodb.lab18.service.ClientPart;
import ru.icmit.oodb.lab18.service.ClientService;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ClientService service;

    @GetMapping(value="/")
    @ResponseBody
    public String index() {
        return "<html><body>" +
                "<a href='/select?id=3'>SELECT</a><br/>" +
                "<a href='/selectclientaccount'>SELECT CLIENT ACCOUNT</a><br/>" +
                "<a href='/selectbankclients'>SELECT CLIENTS OF BANK</a><br/>" +
                "<a href='/selectpart'>SELECT PART</a><br/>" +
                "<a href='/update?id=3'>UPDATE</a><br/>" +
                "<a href='/delete?id=3'>DELETE ONE</a><br/>" +
                "<a href='/deletemany'>DELETE MANY</a><br/>" +
                "</body></html>";
    }

    @GetMapping(value="/update")
    @ResponseBody
    public String update(@RequestParam(name = "id") Long id) {

        int n = service.updateClientName(id, "Клиент 04");

        return "<html><body>" +
                "<a href='/select?id=3'>SELECT</a><br/>" +
                "<a href='/update?id=3'>UPDATE</a><br/>" +
                "<a href='/delete?id=3'>DELETE ONE</a><br/>" +
                "<a href='/deletemany'>DELETE MANY</a><br/>" +
                "<h1>updated " + n + " records</h1>" +
                "</body></html>";
    }

    @GetMapping(value="/delete")
    @ResponseBody
    public String delete(@RequestParam(name = "id") Long id) {

        int n = service.deleteClient(id);

        return "<html><body>" +
                "<a href='/select?id=3'>SELECT</a><br/>" +
                "<a href='/update?id=3'>UPDATE</a><br/>" +
                "<a href='/delete?id=3'>DELETE ONE</a><br/>" +
                "<a href='/deletemany'>DELETE MANY</a><br/>" +
                "<h1>delete " + n + " records</h1>" +
                "</body></html>";
    }

    @GetMapping(value="/deletemany")
    @ResponseBody
    public String deleteMany() {

        int n = service.deleteManyClient();

        return "<html><body>" +
                "<a href='/select?id=3'>SELECT</a><br/>" +
                "<a href='/update?id=3'>UPDATE</a><br/>" +
                "<a href='/delete?id=3'>DELETE ONE</a><br/>" +
                "<a href='/deletemany'>DELETE MANY</a><br/>" +
                "<h1>delete many:" + n + " records</h1>" +
                "</body></html>";
    }

    @GetMapping(value="/select")
    @ResponseBody
    public String select() {

        List<Client> clientList = service.select();

        StringBuilder clientData = new StringBuilder();

        clientList.forEach(c->{
            clientData.append(c.getId() + "," + c.getName() + ", " + c.getBank().getId() +";");
        });

        return "<html><body>" +
                "<a href='/select?id=3'>SELECT</a><br/>" +
                "<a href='/update?id=3'>UPDATE</a><br/>" +
                "<a href='/delete?id=3'>DELETE ONE</a><br/>" +
                "<a href='/deletemany'>DELETE MANY</a><br/>" +
                "<h1>" + clientData.toString() + "</h1>" +
                "</body></html>";
    }

    @GetMapping(value="/selectpart")
    @ResponseBody
    public String selectPart() {

        List<ClientPart> clientList = service.selectPart();

        StringBuilder clientData = new StringBuilder();

        clientList.forEach(c->{
            clientData.append(c.getId() + "," + c.getName() + ";");
        });

        return "<html><body>" +
                "<a href='/select?id=3'>SELECT</a><br/>" +
                "<a href='/update?id=3'>UPDATE</a><br/>" +
                "<a href='/delete?id=3'>DELETE ONE</a><br/>" +
                "<a href='/deletemany'>DELETE MANY</a><br/>" +
                "<h1>" + clientData.toString() + "</h1>" +
                "</body></html>";
    }

    @GetMapping(value="/selectclientaccount")
    @ResponseBody
    public String selectClientAccount() {

        List<Client> clientList = service.selectClientAccount();

        StringBuilder clientData = new StringBuilder();

        clientList.forEach(c->{
            clientData.append("{" + c.getId() + "," + c.getName() + ", " + c.getAccounts() + "};");
        });

        return "<html><body>" +
                "<a href='/select?id=3'>SELECT</a><br/>" +
                "<a href='/update?id=3'>UPDATE</a><br/>" +
                "<a href='/delete?id=3'>DELETE ONE</a><br/>" +
                "<a href='/deletemany'>DELETE MANY</a><br/>" +
                "<h1>" + clientData.toString() + "</h1>" +
                "</body></html>";
    }

    @GetMapping(value="/selectbankclients")
    @ResponseBody
    public String selectBankClients() {

        List<Client> clientList = service.selectClientAccount();

        StringBuilder clientData = new StringBuilder();

        clientList.forEach(c->{
            clientData.append("{" + c.getId() + "," + c.getName() + "};");
        });

        return "<html><body>" +
                "<a href='/select?id=3'>SELECT</a><br/>" +
                "<a href='/update?id=3'>UPDATE</a><br/>" +
                "<a href='/delete?id=3'>DELETE ONE</a><br/>" +
                "<a href='/deletemany'>DELETE MANY</a><br/>" +
                "<h1>" + clientData.toString() + "</h1>" +
                "</body></html>";
    }
}
