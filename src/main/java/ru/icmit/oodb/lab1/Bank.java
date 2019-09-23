package ru.icmit.oodb.lab1;

import java.util.List;

public class Bank {

    private String name;

    private List<Worker> workers;

    private List<Client> clients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addWorker(Worker worker) {
        if (!workers.contains(worker)) {
            workers.add(worker);
        }
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }
}