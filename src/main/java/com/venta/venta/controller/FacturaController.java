package com.venta.venta.controller;

import com.venta.venta.model.Factura;
import com.venta.venta.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> obtenerTodasLasFacturas() {
        return new ResponseEntity<>(facturaService.listarFacturas(), HttpStatus.OK);
    }

    @GetMapping("/{codFactura}")
    public ResponseEntity<Factura> obtenerFactura(@PathVariable Integer codFactura) {
        Optional<Factura> factura = facturaService.obtenerFacturaPorCodigo(codFactura);
        return factura.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        Factura nuevaFactura = facturaService.guardarFactura(factura);
        return new ResponseEntity<>(nuevaFactura, HttpStatus.CREATED);
    }

    @PutMapping("/{codFactura}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Integer codFactura, @RequestBody Factura factura) {
        Factura facturaActualizada = facturaService.actualizarFactura(codFactura, factura);
        if (facturaActualizada != null) {
            return new ResponseEntity<>(facturaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codFactura}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Integer codFactura) {
        facturaService.eliminarFactura(codFactura);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}