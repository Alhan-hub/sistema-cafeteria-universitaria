package com.cafeteria.backend.service;

import com.cafeteria.backend.model.Cliente;
import com.cafeteria.backend.model.Pedido;
import com.cafeteria.backend.model.Producto;
import com.cafeteria.backend.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final ClienteService clienteService;
    private final ProductoService productoService;

    public PedidoService(PedidoRepository repository, ClienteService clienteService, ProductoService productoService) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.productoService = productoService;
    }

    public Pedido crearPedido(String documento, int productoId, int cantidad) {
        Cliente cliente = clienteService.buscarPorDocumento(documento);
        Producto producto = productoService.buscarProducto(productoId);

        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente para: " + producto.getNombre());
        }

        // Descontar stock (lógica de negocio)
        producto.setStock(producto.getStock() - cantidad);
        productoService.registrarProducto(producto); // Actualiza el producto

        return repository.save(new Pedido(cliente, producto, cantidad));
    }

    public List<Pedido> obtenerPedidos() {
        return repository.findAll();
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}