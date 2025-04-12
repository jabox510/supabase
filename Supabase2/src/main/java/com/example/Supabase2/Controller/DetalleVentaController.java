package com.example.Supabase2.Controller;

import com.example.Supabase2.Model.DetalleVenta;
import com.example.Supabase2.Service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> getAllDetalles() {
        return detalleVentaService.getAllDetalles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> getDetalleById(@PathVariable Long id) {
        return detalleVentaService.getDetalleById(id);
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> createDetalle(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.createDetalle(detalleVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> updateDetalle(@PathVariable Long id, @RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.updateDetalle(id, detalleVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable Long id) {
        return detalleVentaService.deleteDetalle(id);
    }
}
