package com.example.Supabase2.Service;

import com.example.Supabase2.Model.Empleado;
import com.example.Supabase2.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        return ResponseEntity.ok(empleadoRepository.findAll());
    }

    public ResponseEntity<Empleado> getEmpleadoById(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Empleado> createEmpleado(Empleado empleado) {
        return ResponseEntity.ok(empleadoRepository.save(empleado));
    }

    public ResponseEntity<Empleado> updateEmpleado(Long id, Empleado empleado) {
        if (!empleadoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empleado.setId(id);
        return ResponseEntity.ok(empleadoRepository.save(empleado));
    }

    public ResponseEntity<Void> deleteEmpleado(Long id) {
        if (!empleadoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empleadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
