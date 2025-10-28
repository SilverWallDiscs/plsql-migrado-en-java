package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MONTO_INGRESO")
public class MontoIngreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codMontoIngreso;
    private Long ingreso;

    @ManyToOne
    @JoinColumn(name = "nro_cliente")  // Solo la relación, sin campo extra
    private Cliente cliente;

    // Getters y setters
    public Long getCodMontoIngreso() { return codMontoIngreso; }
    public void setCodMontoIngreso(Long codMontoIngreso) { this.codMontoIngreso = codMontoIngreso; }
    public Long getIngreso() { return ingreso; }
    public void setIngreso(Long ingreso) { this.ingreso = ingreso; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    // Método helper para acceder al nroCliente sin campo extra
    public Long getNroCliente() {
        return cliente != null ? cliente.getNroCliente() : null;
    }
}