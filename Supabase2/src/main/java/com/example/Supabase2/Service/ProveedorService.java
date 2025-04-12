package com.example.Supabase2.Service;

import com.example.Supabase2.Model.Proveedor;
import com.example.Supabase2.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public ResponseEntity<List<Proveedor>> getAllProveedores() {
        return ResponseEntity.ok(proveedorRepository.findAll());
    }

    public ResponseEntity<Proveedor> getProveedorById(Long id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        return proveedor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Proveedor> createProveedor(Proveedor proveedor) {
        return ResponseEntity.ok(proveedorRepository.save(proveedor));
    }

    public ResponseEntity<Proveedor> updateProveedor(Long id, Proveedor proveedor) {
        if (!proveedorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proveedor.setId(id);
        return ResponseEntity.ok(proveedorRepository.save(proveedor));
    }

    public ResponseEntity<Void> deleteProveedor(Long id) {
        if (!proveedorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proveedorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
