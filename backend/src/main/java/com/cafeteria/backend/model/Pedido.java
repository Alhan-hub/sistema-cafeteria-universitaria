package com.cafeteria.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Producto producto;

    private Integer cantidad;

    private LocalDateTime fechaPedido;
    private String estado; // E.g., "PENDIENTE", "ENTREGADO"

    public Pedido(Cliente cliente, Producto producto, Integer cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaPedido = LocalDateTime.now();
        this.estado = "PENDIENTE";
    }
}