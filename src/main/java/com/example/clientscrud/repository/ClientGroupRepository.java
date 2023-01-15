package com.example.clientscrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.clientscrud.model.ClientGroup;

@RepositoryRestResource(collectionResourceRel = "clientGroups", path = "clientGroups")
public interface ClientGroupRepository extends JpaRepository<ClientGroup, Long> {
    void deleteClientGroupById(Long id);

    Optional<ClientGroup> findClientGroupById(Long id);
}
