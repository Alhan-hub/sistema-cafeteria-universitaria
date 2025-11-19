package com.cafeteria.backend.service;

import com.cafeteria.backend.model.Producto;
import com.cafeteria.backend.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerProductos() {
        return repository.findAll();
    }

    public Producto buscarProducto(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto registrarProducto(Producto producto) {
        return repository.save(producto);
    }
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}