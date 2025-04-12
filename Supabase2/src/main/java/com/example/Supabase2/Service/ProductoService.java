package com.example.Supabase2.Service;

import com.example.Supabase2.Model.Producto;
import com.example.Supabase2.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ResponseEntity<List<Producto>> getAllProductos() {
        return ResponseEntity.ok(productoRepository.findAll());
    }

    public ResponseEntity<Producto> getProductoById(Long id) {
        return productoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Producto> createProducto(Producto producto) {
        Producto saved = productoRepository.save(producto);
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<Producto> updateProducto(Long id, Producto productoDetails) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Producto producto = productoOptional.get();
        producto.setNombre(productoDetails.getNombre());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setPrecio(productoDetails.getPrecio());
        producto.setStock(productoDetails.getStock());
        producto.setProveedor(productoDetails.getProveedor());
        return ResponseEntity.ok(productoRepository.save(producto));
    }

    public ResponseEntity<Void> deleteProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<Producto>> getProductosByProveedor(Long proveedorId) {
        List<Producto> productos = productoRepository.findProductosByProveedorId(proveedorId);
        return ResponseEntity.ok(productos);
    }

}
