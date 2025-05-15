package com.venta.venta.controller;

import com.venta.venta.model.ProductoVenta;
import com.venta.venta.service.ProductoVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos-venta")
public class ProductoVentaController {

    @Autowired
    private ProductoVentaService productoVentaService;

    @GetMapping
    public ResponseEntity<List<ProductoVenta>> obtenerTodosLosProductosVenta() {
        return new ResponseEntity<>(productoVentaService.listarProductosVenta(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoVenta> obtenerProductoVenta(@PathVariable Integer id) {
        Optional<ProductoVenta> productoVenta = productoVentaService.obtenerProductoVentaPorId(id);
        return productoVenta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProductoVenta> crearProductoVenta(@RequestBody ProductoVenta productoVenta) {
        ProductoVenta nuevoProductoVenta = productoVentaService.guardarProductoVenta(productoVenta);
        return new ResponseEntity<>(nuevoProductoVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoVenta> actualizarProductoVenta(@PathVariable Integer id, @RequestBody ProductoVenta productoVenta) {
        ProductoVenta productoVentaActualizado = productoVentaService.actualizarProductoVenta(id, productoVenta);
        if (productoVentaActualizado != null) {
            return new ResponseEntity<>(productoVentaActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProductoVenta(@PathVariable Integer id) {
        productoVentaService.eliminarProductoVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}