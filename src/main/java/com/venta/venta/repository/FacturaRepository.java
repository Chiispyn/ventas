package com.venta.venta.repository;

import com.venta.venta.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    // Puedes agregar métodos de consulta personalizados si es necesario
}