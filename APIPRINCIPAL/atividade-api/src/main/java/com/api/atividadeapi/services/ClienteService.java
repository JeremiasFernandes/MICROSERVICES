package com.api.atividadeapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.atividadeapi.models.ClienteModel;
import com.api.atividadeapi.repositories.ClienteRepository;


import jakarta.transaction.Transactional;


@Service
public class ClienteService {
    


    @Autowired
    ClienteRepository clienteRepository;


    @Transactional
    public ClienteModel save(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

   
    public boolean seExisteClienteByCpf(String cpfCliente){
   
        return clienteRepository.existsByCpf(cpfCliente);
        
    }

    
}
