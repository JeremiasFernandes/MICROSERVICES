package main.java.com.recargaAPI.recargaAPI.listener;



import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.recargaAPI.recargaAPI.dto.PagamentoDto;








@Component
public class RecargaCriadaListener {
    
@Autowired
private RabbitTemplate rabbitTemplate;



@RabbitListener(queues = "recarga.v1.criar-recarga")
public void aoCriarUmaVenda(PagamentoDto pagamentoDto){
    

    String nomeFila =  "recarga.v1.retorna-status-pagamentos";
    pagamentoDto.setSTATUS("AUTORIZADO");

    
    rabbitTemplate.convertAndSend(nomeFila, pagamentoDto);
    System.out.println("Recarga com valor de " + pagamentoDto.getValorDaRecarga() + " criada");

}

}
