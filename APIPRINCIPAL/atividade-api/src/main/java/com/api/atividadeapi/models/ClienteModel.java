package com.api.atividadeapi.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.persistence.*;


@Entity
@Table(name = "Cliente_TABLE")
public class ClienteModel implements Serializable {
    
    private static final long  serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = false, length = 20)
    private String nome;

    @Column(nullable = false, unique = true, length = 20)
    private String cpf;

    @Column(nullable = true)
    private String email;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 


}
