package com.cafeteria.frontend.dtos;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class PedidoDTO {
    private Long id;
    private ClienteDTO cliente;
    private ProductoDTO producto;
    private Integer cantidad;
    private LocalDateTime fechaPedido;
    private String estado;
}