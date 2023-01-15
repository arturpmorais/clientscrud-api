package com.example.clientscrud.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientscrud.model.ClientGroup;
import com.example.clientscrud.service.ClientGroupService;

@RestController
@RequestMapping("/clientGroup")
public class ClientGroupResource {
    private final ClientGroupService clientGroupService;

    public ClientGroupResource(ClientGroupService clientGroupService) {
        this.clientGroupService = clientGroupService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientGroup>> getAllClientGroups() {
        List<ClientGroup> clientGroups = clientGroupService.findAllClientGroups();
        return new ResponseEntity<>(clientGroups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientGroup> getClientGroupById(@PathVariable("id") Long id) {
        ClientGroup clientGroup = clientGroupService.findClientGroupById(id);
        return new ResponseEntity<>(clientGroup, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ClientGroup> addClientGroup(@RequestBody ClientGroup clientGroup) {
        ClientGroup newClientGroup = clientGroupService.addClientGroup(clientGroup);
        return new ResponseEntity<>(newClientGroup, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<ClientGroup> updateClientGroup(@RequestBody ClientGroup clientGroup) {
        ClientGroup updateClientGroup = clientGroupService.updateClientGroup(clientGroup);
        return new ResponseEntity<>(updateClientGroup, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClientGroup(@PathVariable("id") Long id) {
        clientGroupService.deleteClientGroup(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
