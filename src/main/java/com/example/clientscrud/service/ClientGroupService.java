package com.example.clientscrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clientscrud.model.ClientGroup;
import com.example.clientscrud.repository.ClientGroupRepository;

@Service
public class ClientGroupService {
    private final ClientGroupRepository clientGroupRepository;

    @Autowired
    public ClientGroupService(ClientGroupRepository clientGroupRepository) {
        this.clientGroupRepository = clientGroupRepository;
    }

    public ClientGroup findClientGroupById(Long id) {
        return clientGroupRepository.findClientGroupById(id)
            .orElseThrow(() -> new RuntimeException("Client Group with id " + id + " not found"));
    }

    public List<ClientGroup> findAllClientGroups() {
        return clientGroupRepository.findAll();
    }

    public ClientGroup addClientGroup(ClientGroup clientGroup) {
        return clientGroupRepository.save(clientGroup);
    }

    public ClientGroup updateClientGroup(ClientGroup clientGroup) {
        return clientGroupRepository.save(clientGroup);
    }

    public void deleteClientGroup(Long id) {
        clientGroupRepository.deleteClientGroupById(id);
    }
}
