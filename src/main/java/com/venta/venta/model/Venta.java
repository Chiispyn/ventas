package com.venta.venta.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
    private Date fechaVenta;
    private Double totalVenta;
    private Integer idPedido;
    private Integer idCliente;
    private Integer idUsuario;
    private Float descuento;
    @Enumerated(EnumType.STRING)
    private MedioEnvio metodoEnvio;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<ProductoVenta> productosVenta;
}