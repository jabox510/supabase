package com.example.Supabase2.Service;

import com.example.Supabase2.Model.DetalleVenta;
import com.example.Supabase2.Repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public ResponseEntity<List<DetalleVenta>> getAllDetalles() {
        List<DetalleVenta> detalles = detalleVentaRepository.findAll();
        return ResponseEntity.ok(detalles);
    }

    public ResponseEntity<DetalleVenta> getDetalleById(Long id) {
        Optional<DetalleVenta> detalle = detalleVentaRepository.findById(id);
        return detalle.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<DetalleVenta> createDetalle(DetalleVenta detalleVenta) {
        DetalleVenta nuevoDetalle = detalleVentaRepository.save(detalleVenta);
        return ResponseEntity.ok(nuevoDetalle);
    }

    public ResponseEntity<DetalleVenta> updateDetalle(Long id, DetalleVenta detalleVenta) {
        if (!detalleVentaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        detalleVenta.setId(id);
        DetalleVenta actualizado = detalleVentaRepository.save(detalleVenta);
        return ResponseEntity.ok(actualizado);
    }

    public ResponseEntity<Void> deleteDetalle(Long id) {
        if (!detalleVentaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        detalleVentaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<DetalleVenta>> getDetallesByEmpleadoAndCliente(Long empleadoId, Long clienteId) {
        List<DetalleVenta> detalles = detalleVentaRepository.findDetallesByEmpleadoAndCliente(empleadoId, clienteId);
        return ResponseEntity.ok(detalles);
    }




}
