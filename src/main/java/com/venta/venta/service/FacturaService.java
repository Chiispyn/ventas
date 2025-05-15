package com.venta.venta.service;

import com.venta.venta.model.Factura;
import com.venta.venta.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> obtenerFacturaPorCodigo(Integer codFactura) {
        return facturaRepository.findById(codFactura);
    }

    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura actualizarFactura(Integer codFactura, Factura factura) {
        return facturaRepository.findById(codFactura)
                .map(existingFactura -> {
                    if (factura.getFechaEmisio() != null) existingFactura.setFechaEmisio(factura.getFechaEmisio());
                    if (factura.getTotalFactura() != null) existingFactura.setTotalFactura(factura.getTotalFactura());
                    if (factura.getEnviarCorreo() != null) existingFactura.setEnviarCorreo(factura.getEnviarCorreo());
                    return facturaRepository.save(existingFactura);
                })
                .orElse(null);
    }

    public void eliminarFactura(Integer codFactura) {
        facturaRepository.deleteById(codFactura);
    }
}