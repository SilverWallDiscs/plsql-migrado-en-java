package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    private Long nroCliente;

    @ManyToOne
    @JoinColumn(name = "cod_tipo_cliente")  // Solo la relación, sin campo extra
    private TipoCliente tipoCliente;

    // Getters y setters
    public Long getNroCliente() { return nroCliente; }
    public void setNroCliente(Long nroCliente) { this.nroCliente = nroCliente; }
    public TipoCliente getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(TipoCliente tipoCliente) { this.tipoCliente = tipoCliente; }

    // Método helper para acceder al codTipoCliente sin campo extra
    public Long getCodTipoCliente() {
        return tipoCliente != null ? tipoCliente.getCodTipoCliente() : null;
    }
}