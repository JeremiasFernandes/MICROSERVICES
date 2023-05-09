package com.api.atividadeapi.controllers;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.api.atividadeapi.dtos.ClienteDto;
import com.api.atividadeapi.models.ClienteModel;
import com.api.atividadeapi.services.ClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("v1/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    RabbitTemplate rabbitTemplate;


    @PostMapping
    public ResponseEntity<Object> salvarCliente(@RequestBody @Valid ClienteDto clienteDto){
        

        //verifica se existe um cliente ja cadastrado com o cpf informado.
        if (clienteService.seExisteClienteByCpf(clienteDto.getCpf())){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Cliente ja existe!");
        }

        //cria o objeto cliente para ser salvo no banco.
        var clienteModel =  new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel); 
        clienteService.save(clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }
    

}


   



