package com.venta.venta.repository;

import com.venta.venta.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    // Puedes agregar métodos de consulta personalizados si es necesario
}