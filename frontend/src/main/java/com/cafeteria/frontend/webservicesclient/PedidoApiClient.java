package com.cafeteria.frontend.webservicesclient;

import com.cafeteria.frontend.dtos.PedidoDTO;
import com.cafeteria.frontend.dtos.PedidoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="pedido-api-client", url="${api.cafeteria.base-url}")
public interface PedidoApiClient {

    @PostMapping("/pedidos")
    PedidoDTO crearPedido(@RequestBody PedidoRequest request);

    @GetMapping("/pedidos")
    List<PedidoDTO> listarPedidos();

    @DeleteMapping("/pedidos/{id}")
    void eliminar(@PathVariable("id") Long id);
}