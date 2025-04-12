package com.example.Supabase2.Repository;

import com.example.Supabase2.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

    @Query(value = "SELECT dv.* FROM detalle_venta dv " +
            "JOIN venta v ON dv.id_venta = v.id " +
            "WHERE v.id_empleado = :empleadoId AND v.id_cliente = :clienteId", nativeQuery = true)
    List<DetalleVenta> findDetallesByEmpleadoAndCliente(@Param("empleadoId") Long empleadoId, @Param("clienteId") Long clienteId);


}
