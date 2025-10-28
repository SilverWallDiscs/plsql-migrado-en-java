package com.example.demo.repository;

import com.example.demo.entity.MontoIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MontoIngresoRepository extends JpaRepository<MontoIngreso, Long> {
    @Query("SELECT mi FROM MontoIngreso mi JOIN mi.cliente c JOIN c.tipoCliente tc")
    List<MontoIngreso> findAllWithJoins();  // Para simular el cursor
}