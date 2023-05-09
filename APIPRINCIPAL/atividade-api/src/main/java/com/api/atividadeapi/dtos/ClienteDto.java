package com.api.atividadeapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteDto {


@NotBlank
@Size(max = 20)
private String Nome;

@NotBlank
@Size(max = 20)
private String Cpf;


@NotBlank
@Size(max = 20)
private String Email;


public String getNome() {
    return Nome;
}


public void setNome(String nome) {
    Nome = nome;
}


public String getCpf() {
    return Cpf;
}


public void setCpf(String cpf) {
    Cpf = cpf;
}


public String getEmail() {
    return Email;
}


public void setEmail(String email) {
    Email = email;
}



    
}
