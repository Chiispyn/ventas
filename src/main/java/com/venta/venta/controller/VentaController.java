package com.venta.venta.controller;

import com.venta.venta.model.Venta;
import com.venta.venta.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> obtenerTodasLasVentas() {
        return new ResponseEntity<>(ventaService.listarVentas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Integer id) {
        Optional<Venta> venta = ventaService.obtenerVentaPorId(id);
        return venta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.guardarVenta(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        Venta ventaActualizada = ventaService.actualizarVenta(id, venta);
        if (ventaActualizada != null) {
            return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Integer id) {
        ventaService.eliminarVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}