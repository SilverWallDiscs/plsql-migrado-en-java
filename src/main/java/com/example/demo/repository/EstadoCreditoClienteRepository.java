package com.example.demo.repository;

import com.example.demo.entity.EstadoCreditoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoCreditoClienteRepository extends JpaRepository<EstadoCreditoCliente, Long> {
    boolean existsByNroCliente(Long nroCliente);
}