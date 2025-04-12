package com.example.Supabase2.Service;

import com.example.Supabase2.Model.Venta;
import com.example.Supabase2.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public ResponseEntity<List<Venta>> getAllVentas() {
        return ResponseEntity.ok(ventaRepository.findAll());
    }

    public ResponseEntity<Venta> getVentaById(Long id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        return venta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Venta> createVenta(Venta venta) {
        return ResponseEntity.ok(ventaRepository.save(venta));
    }

    public ResponseEntity<Venta> updateVenta(Long id, Venta venta) {
        if (!ventaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        venta.setId(id);
        return ResponseEntity.ok(ventaRepository.save(venta));
    }

    public ResponseEntity<Void> deleteVenta(Long id) {
        if (!ventaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ventaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



    public ResponseEntity<List<Venta>> getVentasByEmpleadoAndCliente(Long empleadoId, Long clienteId) {
        List<Venta> ventas = ventaRepository.findVentasByEmpleadoAndCliente(empleadoId, clienteId);
        return ResponseEntity.ok(ventas);
    }


}
