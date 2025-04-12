package com.example.Supabase2.Repository;

import com.example.Supabase2.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    // Total de ventas por empleado
    @Query("SELECT v.empleado.nombre, SUM(d.precioUnitario * d.cantidad) FROM Venta v JOIN v.detalles d GROUP BY v.empleado.nombre")
    List<Object[]> obtenerTotalVentasPorEmpleado();

    // Detalle de ventas por cliente
    @Query("SELECT v FROM Venta v WHERE v.cliente.id = :clienteId")
    List<Venta> buscarVentasPorCliente(Long clienteId);

    @Query(value = "SELECT * FROM venta WHERE id_empleado = :empleadoId", nativeQuery = true)
    List<Venta> findVentasByEmpleado(@Param("empleadoId") Long empleadoId);

    @Query(value = "SELECT * FROM venta WHERE id_empleado = :empleadoId AND id_cliente = :clienteId", nativeQuery = true)
    List<Venta> findVentasByEmpleadoAndCliente(@Param("empleadoId") Long empleadoId, @Param("clienteId") Long clienteId);



}
