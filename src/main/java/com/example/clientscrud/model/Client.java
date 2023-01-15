package com.example.clientscrud.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Client {

    public Client() {}

    public Client(String name, String documentType, String document1, String document2, Date registrationDate, ClientGroup clientGroup, Boolean active) {
        this.name = name;
        this.documentType = documentType;
        this.document1 = document1;
        this.document2 = document2;
        this.registrationDate = registrationDate;
        this.clientGroup = clientGroup;
        this.active = active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String documentType;

    @Column(nullable = false)
    private String document1;

    @Column(nullable = false)
    private String document2;

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

    public String getDocument1() {
        return document1;
    }

    public void setDocument1(String document) {
        this.document1 = document;
    }

    public String getDocument2() {
        return document2;
    }

    public void setDocument2(String document2) {
        this.document2 = document2;
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
