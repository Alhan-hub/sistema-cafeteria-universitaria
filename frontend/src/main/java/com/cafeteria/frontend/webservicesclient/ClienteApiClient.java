package com.cafeteria.frontend.webservicesclient;

import com.cafeteria.frontend.dtos.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
// IMPORTANTE: Esta línea trae todas las anotaciones web (PostMapping, DeleteMapping, RequestBody, etc.)
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="cliente-api-client", url="${api.cafeteria.base-url}")
public interface ClienteApiClient {

    @GetMapping("/clientes/todos")
    List<ClienteDTO> getClientes();

    @GetMapping("/clientes/documento/{documento}")
    ClienteDTO getClientePorDocumento(@PathVariable("documento") String documento);



    @PostMapping("/clientes")
    ClienteDTO registrar(@RequestBody ClienteDTO cliente);

    @DeleteMapping("/clientes/{documento}")
    void eliminar(@PathVariable("documento") String documento);
}