package com.example.clientscrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clientscrud.model.Client;
import com.example.clientscrud.repository.ClientRepository;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientById(Long id) {
        return clientRepository.findClientById(id)
            .orElseThrow(() -> new RuntimeException("Client Group with id " + id + " not found"));
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteClientById(id);
    }
}
