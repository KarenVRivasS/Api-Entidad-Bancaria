package com.accenture.entidades_bancarias_api.controller;

import com.accenture.entidades_bancarias_api.exception.RecursoNoEncontradoException;
import com.accenture.entidades_bancarias_api.model.entity.EntidadBancaria;
import com.accenture.entidades_bancarias_api.service.EntidadBancariaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/cliente")
public class ClientSelfCtrl {

    private final EntidadBancariaService entidadBancariaService;
    private final WebClient webClient;

    public ClientSelfCtrl(EntidadBancariaService entidadBancariaService, WebClient.Builder webClientBuilder) {
        this.entidadBancariaService = entidadBancariaService;
        this.webClient = webClientBuilder.build();    }

    @GetMapping("/self/{id}")
    public EntidadBancaria ObtenerBancoComoCliente(@PathVariable Long id) {

       String endpointUrl = "http://localhost:8080/api/bancos/obtener/" + id;
        try {
        EntidadBancaria banco = webClient
                .get()
                .uri(endpointUrl)
                .header("Content-Type", "application/json")
                .retrieve()
                .bodyToMono(EntidadBancaria.class)
                .block();
        EntidadBancaria response = banco;
        return response;
        } catch(Exception ex) {
            throw new RecursoNoEncontradoException("Banco con ID " + id + " no encontrado");
        }
    }
}
