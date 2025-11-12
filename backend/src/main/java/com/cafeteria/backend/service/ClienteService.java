package com.cafeteria.backend.service;

import com.cafeteria.backend.model.Cliente;
import com.cafeteria.backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente registrar(Cliente c) {
        return repository.save(c);
    }

    public Cliente buscarPorDocumento(String documento) {
        return repository.findById(documento)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}