package com.example.clientscrud.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String documentType;

    @Column(nullable = false)
    private String document;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private Date registrationDate;

    @ManyToOne
    @JoinColumn(name = "forumId")
    private ClientGroup clientGroup;

    @Column(nullable = false)
    private Boolean active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ClientGroup getClientGroup() {
        return clientGroup;
    }

    public void setClientGroup(ClientGroup clientGroup) {
        this.clientGroup = clientGroup;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
