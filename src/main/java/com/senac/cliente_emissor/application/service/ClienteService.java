package com.senac.cliente_emissor.application.service;

import com.senac.cliente_emissor.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final RabbitTemplate rabbitTemplate;

    public  Cliente adicionarCliente(Cliente cliente){
        rabbitTemplate.convertAndSend("fila-ecommerce",cliente);
        return cliente;
    }

}
