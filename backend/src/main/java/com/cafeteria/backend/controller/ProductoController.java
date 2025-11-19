package com.cafeteria.backend.controller;

import com.cafeteria.backend.model.Producto;
import com.cafeteria.backend.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Lista todos los productos disponibles")
    public List<Producto> listarProductos() {
        return service.obtenerProductos();
    }

    @PostMapping
    @Operation(summary = "Registra un nuevo producto")
    public Producto registrarProducto(@RequestBody Producto producto) {
        return service.registrarProducto(producto);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id); // Crea este método en el servicio
    }
}