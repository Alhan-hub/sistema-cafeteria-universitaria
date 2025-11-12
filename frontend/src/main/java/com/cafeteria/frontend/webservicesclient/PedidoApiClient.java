package com.cafeteria.frontend.webservicesclient;

import com.cafeteria.frontend.dtos.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// DTO para la solicitud de pedido
record PedidoRequest(String documentoCliente, int productoId, int cantidad) {}


@FeignClient(name="pedido-api-client", url="${api.cafeteria.base-url}")
public interface PedidoApiClient {

    @PostMapping("/pedidos")
    PedidoDTO crearPedido(@RequestBody PedidoRequest request);
}