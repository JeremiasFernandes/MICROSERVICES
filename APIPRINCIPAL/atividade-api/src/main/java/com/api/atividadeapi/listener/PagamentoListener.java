package com.api.atividadeapi.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.atividadeapi.dtos.PagamentoDto;
import com.api.atividadeapi.models.RecargaModel;
import com.api.atividadeapi.services.RecargaService;

@Component
public class PagamentoListener {
    

    @Autowired
    RecargaService recargaService;

@RabbitListener(queues = "recarga.v1.retorna-status-pagamentos")
    public void StatusPagamento(PagamentoDto pagamentoDto){

        RecargaModel recargaModel = recargaService.AtualizarStatusPagamento(pagamentoDto.getIdRecarga(), "AUTORIZADO");
        System.out.println(recargaModel.getSTATUS());
    }

}
