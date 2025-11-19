package com.cafeteria.backend.controller;

import com.cafeteria.backend.model.Pedido;
import com.cafeteria.backend.service.PedidoService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // DTO simple para recibir la petición de crear pedido
    public record PedidoRequest(String documentoCliente, int productoId, int cantidad) {}

    @PostMapping
    @Operation(summary = "Crea un nuevo pedido")
    public Pedido crearPedido(@RequestBody PedidoRequest request) {
        return service.crearPedido(request.documentoCliente(), request.productoId(), request.cantidad());
    }

    @GetMapping
    @Operation(summary = "Obtiene todos los pedidos registrados")
    public List<Pedido> listar() {
        return service.obtenerPedidos();
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
    service.eliminar(id); // Crea este método en el servicio
    }
}