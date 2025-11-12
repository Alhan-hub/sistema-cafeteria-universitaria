package com.cafeteria.frontend.dtos;


public record PedidoRequest(String documentoCliente, int productoId, int cantidad) {
}
