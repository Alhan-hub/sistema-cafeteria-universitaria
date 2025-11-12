package com.cafeteria.backend.controller;

import com.cafeteria.backend.model.Cliente;
import com.cafeteria.backend.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation; // Import para Swagger

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Registra un nuevo cliente")
    public Cliente registrar(@RequestBody Cliente cliente) {
        return service.registrar(cliente);
    }

    @GetMapping("/{documento}")
    @Operation(summary = "Busca un cliente por su documento")
    public Cliente buscar(@PathVariable String documento) {
        return service.buscarPorDocumento(documento);
    }
}