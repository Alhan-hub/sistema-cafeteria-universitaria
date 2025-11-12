package com.cafeteria.frontend.webservicesclient;

import com.cafeteria.frontend.dtos.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="producto-api-client", url="${api.cafeteria.base-url}")
public interface ProductoApiClient {

    @GetMapping("/productos")
    List<ProductoDTO> getProductos();
}