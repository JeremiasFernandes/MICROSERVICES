package com.api.atividadeapi.controllers;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.api.atividadeapi.dtos.PagamentoDto;
import com.api.atividadeapi.dtos.RecargaDto;
import com.api.atividadeapi.models.RecargaModel;
import com.api.atividadeapi.services.ClienteService;
import com.api.atividadeapi.services.RecargaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("v1/recarga")
public class RecargaController {

    @Autowired
    RecargaService recargaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

 

    @PostMapping
    public ResponseEntity<Object> salvarRecarga(@RequestBody @Valid RecargaDto recargaDto,  HttpServletRequest request){
        

      
        if(!recargaService.verficacoes(recargaDto)){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Erro com a verificaçao da recarga");
        }   


        //Cria um objeto para ser salvo no banco de dados 
        var recargaModel =  new RecargaModel();
        BeanUtils.copyProperties(recargaDto, recargaModel); 
        recargaModel.setDataDeCriacao(LocalDateTime.now(ZoneId.of("UTC")));
        recargaModel.setSTATUS("EM PROCESSAMENTO");
        recargaModel = recargaService.save(recargaModel);

        ///Cria um um objeto pagamentoDTO para enviar via mensagem ao sistema de pagamento
        PagamentoDto pagamentoDto = new PagamentoDto();
        pagamentoDto.setIdRecarga(recargaModel.getId());
        pagamentoDto.setNumeroDoCelular(recargaModel.getNumeroDoCelular());
        pagamentoDto.setValorDaRecarga(recargaModel.getValorDaRecarga());
        pagamentoDto.setSTATUS("EM PROCESSAMENTO");


        String nomeFila =  "recarga.v1.criar-recarga";
        rabbitTemplate.convertAndSend(nomeFila, pagamentoDto);
 
        return ResponseEntity.status(HttpStatus.CREATED).body("Recarga criada com sucesso!");
    }

    //lista as recargas através de um cpf de ciente
    @GetMapping("/{cpfCliente}")
    public ResponseEntity<List<RecargaModel>> retornaTodasAsRecargasDoCliente(@PathVariable(value = "cpfCliente") String cpfCliente){
        return ResponseEntity.status(HttpStatus.OK).body(recargaService.ListaRecarga(cpfCliente));
    }
    

}


   



