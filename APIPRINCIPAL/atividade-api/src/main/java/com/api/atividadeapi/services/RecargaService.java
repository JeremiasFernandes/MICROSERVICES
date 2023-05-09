package com.api.atividadeapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.atividadeapi.dtos.PagamentoDto;
import com.api.atividadeapi.dtos.RecargaDto;
import com.api.atividadeapi.models.RecargaModel;
import com.api.atividadeapi.repositories.RecargaRepository;

import jakarta.transaction.Transactional;


@Service
public class RecargaService {

    
    @Autowired
    RecargaRepository recargaRepository;

    @Autowired
    ClienteService clienteService;



    @Transactional
    public RecargaModel save(RecargaModel recargaModel){
        return recargaRepository.save(recargaModel);
       
    }


    @Transactional
    public RecargaModel AtualizarStatusPagamento(UUID recargaID, String STATUS){    
        RecargaModel recargaModel = recargaRepository.findById(recargaID).get();
        recargaModel.setSTATUS(STATUS);
        return recargaRepository.save(recargaModel);

    }

    @Transactional
    public List<RecargaModel> ListaRecarga(String cpfCliente){
        return recargaRepository.findByCpfCliente(cpfCliente);
    }

    public boolean verficacoes(RecargaDto recargaDto){

     if(clienteService.seExisteClienteByCpf(recargaDto.getCpfCliente())){
        return true;
    }
        return false;
    }

    



}
