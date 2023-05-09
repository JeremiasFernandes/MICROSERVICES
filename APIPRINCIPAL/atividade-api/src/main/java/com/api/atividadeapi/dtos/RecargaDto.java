package com.api.atividadeapi.dtos;




import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class RecargaDto{



@NotBlank
private String numeroDoCelular;
@NotNull
private int valorDaRecarga;

@NotBlank
private String cpfCliente;





public RecargaDto() {
}

public RecargaDto(@NotBlank String numeroDoCelular, @NotNull int valorDaRecarga, @NotBlank String cpfCliente) {
    this.numeroDoCelular = numeroDoCelular;
    this.valorDaRecarga = valorDaRecarga;
    this.cpfCliente = cpfCliente;
}

public String getNumeroDoCelular() {
    return numeroDoCelular;
}

public void setNumeroDoCelular(String numeroDoCelular) {
    this.numeroDoCelular = numeroDoCelular;
}

public String getCpfCliente() {
    return cpfCliente;
}

public void setCpfCliente(String cpfCliente) {
    this.cpfCliente = cpfCliente;
}

public int getValorDaRecarga() {
    return valorDaRecarga;
}

public void setValorDaRecarga(int valorDaRecarga) {
    this.valorDaRecarga = valorDaRecarga;
}



}