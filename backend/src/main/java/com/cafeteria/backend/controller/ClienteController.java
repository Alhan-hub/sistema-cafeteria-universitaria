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

    @GetMapping("/documento/{documento}")
    public Cliente buscar(@PathVariable String documento) {
        return service.buscarPorDocumento(documento);
    }

    @GetMapping("/todos")
    @Operation(summary = "Lista todos los clientes registrados")
    public java.util.List<Cliente> listarTodos() {
        return service.listarTodos(); // Necesitaremos crear este método en el servicio
    }
    @DeleteMapping("/{documento}")
    public void eliminar(@PathVariable String documento) {
        service.eliminar(documento); //
    }

}
