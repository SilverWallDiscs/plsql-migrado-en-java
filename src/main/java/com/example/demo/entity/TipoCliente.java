package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_CLIENTE")
public class TipoCliente {
    @Id
    private Long codTipoCliente;

    // Getters y setters
    public Long getCodTipoCliente() { return codTipoCliente; }
    public void setCodTipoCliente(Long codTipoCliente) { this.codTipoCliente = codTipoCliente; }
}