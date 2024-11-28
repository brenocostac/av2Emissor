package com.senac.cliente_emissor.controller;

import com.senac.cliente_emissor.application.service.ClienteService;
import com.senac.cliente_emissor.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void> adicionarCliente(@RequestBody Cliente cliente){
        clienteService.adicionarCliente(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


}
