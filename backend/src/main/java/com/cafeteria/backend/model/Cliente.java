package com.cafeteria.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Lombok: genera getters, setters, etc.
@NoArgsConstructor
public class Cliente {
    @Id
    private String documento;
    private String nombre;

    public Cliente(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }
}