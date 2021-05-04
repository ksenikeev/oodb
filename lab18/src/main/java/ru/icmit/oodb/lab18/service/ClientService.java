package ru.icmit.oodb.lab18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.icmit.oodb.lab18.domain.Client;
import ru.icmit.oodb.lab18.repository.ClientEntityManagerRepository;
import ru.icmit.oodb.lab18.repository.ClientJPARepository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientService {

    @Autowired
    private ClientEntityManagerRepository repository;

    @Autowired
    private ClientJPARepository jpaRepository;

    @Transactional
    public int updateClientName(Long id, String newName) {

        Client client = jpaRepository.findById(id).get();
        return repository.updateClientName(client, newName);
    }

    @Transactional
    public int deleteClient(Long id) {
        Client client = jpaRepository.findById(id).orElse(null);
        return repository.deleteClient(client);
    }

    @Transactional
    public int deleteManyClient() {
        List<Client> clients = new ArrayList<>();
        clients.add(jpaRepository.findById(4L).get());
        clients.add(jpaRepository.findById(5L).get());

        return repository.deleteManyClient(clients);
    }

    public List<Client> select() {
        return jpaRepository.selectDistinct();
    }
}
