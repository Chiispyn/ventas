package com.venta.venta.service;

import com.venta.venta.model.Venta;
import com.venta.venta.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> obtenerVentaPorId(Integer id) {
        return ventaRepository.findById(id);
    }

    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta actualizarVenta(Integer id, Venta venta) {
        return ventaRepository.findById(id)
                .map(existingVenta -> {
                    if (venta.getFechaVenta() != null) existingVenta.setFechaVenta(venta.getFechaVenta());
                    if (venta.getTotalVenta() != null) existingVenta.setTotalVenta(venta.getTotalVenta());
                    if (venta.getIdPedido() != null) existingVenta.setIdPedido(venta.getIdPedido());
                    if (venta.getIdCliente() != null) existingVenta.setIdCliente(venta.getIdCliente());
                    if (venta.getIdUsuario() != null) existingVenta.setIdUsuario(venta.getIdUsuario());
                    if (venta.getDescuento() != null) existingVenta.setDescuento(venta.getDescuento());
                    if (venta.getMetodoEnvio() != null) existingVenta.setMetodoEnvio(venta.getMetodoEnvio());
                    if (venta.getProductosVenta() != null) existingVenta.setProductosVenta(venta.getProductosVenta());
                    return ventaRepository.save(existingVenta);
                })
                .orElse(null);
    }

    public void eliminarVenta(Integer id) {
        ventaRepository.deleteById(id);
    }
}