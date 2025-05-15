package com.venta.venta.repository;

import com.venta.venta.model.ProductoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoVentaRepository extends JpaRepository<ProductoVenta, Integer> {
    // Puedes agregar métodos de consulta personalizados si es necesario
}