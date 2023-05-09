package com.api.atividadeapi.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name = "Recarga_TABLE")
public class RecargaModel implements Serializable{
    
    private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID id;


@Column(nullable = false, unique = false, length = 20)
private String numeroDoCelular;

@Column(nullable = false)
private int valorDaRecarga;

@Column(nullable = true)
private LocalDateTime dataDeCriacao;

private String STATUS;

private String cpfCliente;




public UUID getId() {
    return id;
}

public String getSTATUS() {
    return STATUS;
}

public void setSTATUS(String sTATUS) {
    STATUS = sTATUS;
}

public void setId(UUID id) {
    this.id = id;
}


public String getNumeroDoCelular() {
    return numeroDoCelular;
}

public void setNumeroDoCelular(String numeroDoCelular) {
    this.numeroDoCelular = numeroDoCelular;
}

public int getValorDaRecarga() {
    return valorDaRecarga;
}

public void setValorDaRecarga(int valorDaRecarga) {
    this.valorDaRecarga = valorDaRecarga;
}

public LocalDateTime getDataDeCriacao() {
    return dataDeCriacao;
}

public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
    this.dataDeCriacao = dataDeCriacao;
}

public String getcpfCliente() {
    return cpfCliente;
}

public void setcpfCliente(String clienteID) {
    this.cpfCliente = clienteID;
}





}

