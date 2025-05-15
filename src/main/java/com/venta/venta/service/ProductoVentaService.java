package com.venta.venta.service;

import com.venta.venta.model.ProductoVenta;
import com.venta.venta.repository.ProductoVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoVentaService {

    @Autowired
    private ProductoVentaRepository productoVentaRepository;

    public List<ProductoVenta> listarProductosVenta() {
        return productoVentaRepository.findAll();
    }

    public Optional<ProductoVenta> obtenerProductoVentaPorId(Integer id) {
        return productoVentaRepository.findById(id);
    }

    public ProductoVenta guardarProductoVenta(ProductoVenta productoVenta) {
        return productoVentaRepository.save(productoVenta);
    }

    public ProductoVenta actualizarProductoVenta(Integer id, ProductoVenta productoVenta) {
        return productoVentaRepository.findById(id)
                .map(existingProductoVenta -> {
                    if (productoVenta.getVenta() != null) existingProductoVenta.setVenta(productoVenta.getVenta());
                    if (productoVenta.getIdProducto() != null) existingProductoVenta.setIdProducto(productoVenta.getIdProducto());
                    if (productoVenta.getCantidad() != null) existingProductoVenta.setCantidad(productoVenta.getCantidad());
                    if (productoVenta.getPrecioUnitario() != null) existingProductoVenta.setPrecioUnitario(productoVenta.getPrecioUnitario());
                    if (productoVenta.getSubtotal() != null) existingProductoVenta.setSubtotal(productoVenta.getSubtotal());
                    return productoVentaRepository.save(existingProductoVenta);
                })
                .orElse(null);
    }

    public void eliminarProductoVenta(Integer id) {
        productoVentaRepository.deleteById(id);
    }
}