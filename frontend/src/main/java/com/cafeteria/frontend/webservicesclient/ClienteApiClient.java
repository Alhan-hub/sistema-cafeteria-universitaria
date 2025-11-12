package com.cafeteria.frontend.webservicesclient;

import com.cafeteria.frontend.dtos.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// ${api.cafeteria.base-url} se toma de application.properties
@FeignClient(name="cliente-api-client", url="${api.cafeteria.base-url}")
public interface ClienteApiClient {

    // Nota: Spring Data JPA por defecto pagina. Para simplicidad, asumimos que devuelve una lista.
    // En un proyecto real, el backend debería devolver List<Cliente> no paginada
    // o el frontend manejar Page<ClienteDTO>.
    // Asumamos que el backend tiene un GET /api/clientes/todos
    @GetMapping("/clientes/todos") // Necesitarías crear este endpoint en el backend
    List<ClienteDTO> getClientes();

    @GetMapping("/clientes/{documento}")
    ClienteDTO getClientePorDocumento(@PathVariable("documento") String documento);
}