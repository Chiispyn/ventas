package com.venta.venta.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ProductoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta venta;
    private Integer idProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}