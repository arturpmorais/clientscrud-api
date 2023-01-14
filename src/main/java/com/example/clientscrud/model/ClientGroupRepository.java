package com.example.clientscrud.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "clientGroups", path = "clientGroups")
public interface ClientGroupRepository extends JpaRepository<ClientGroup, Long> {
}
