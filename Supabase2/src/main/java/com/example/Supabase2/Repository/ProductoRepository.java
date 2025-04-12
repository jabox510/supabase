package com.example.Supabase2.Repository;

import com.example.Supabase2.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {


    @Query(value = "SELECT * FROM producto WHERE id_proveedor = :proveedorId", nativeQuery = true)
    List<Producto> findProductosByProveedorId(@Param("proveedorId") Long proveedorId);


}

