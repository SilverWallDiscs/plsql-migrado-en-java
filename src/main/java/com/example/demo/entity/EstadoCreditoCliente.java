package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTADO_CREDITO_CLIENTE")
public class EstadoCreditoCliente {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
@Column(name = "cod_estado_credito_cliente")
private Long codEstadoCreditoCliente;

    @Column(name = "ESTADO_HIPOTECARIO")
    private Integer estadoHipotecario;

    @Column(name = "ESTADO_CONSUMO")
    private Integer estadoConsumo;

    @Column(name = "ESTADO_AUTOMOTRIZ")
    private Integer estadoAutomotriz;

    @Column(name = "ESTADO_EMERGENCIA")
    private Integer estadoEmergencia;

    @Column(name = "ESTADO_ARANCEL")
    private Integer estadoArancel;

    @Column(name = "NRO_CLIENTE")
    private Long nroCliente;

    // Getters y setters
    public Long getCodEstadoCreditoCliente() { return codEstadoCreditoCliente; }
    public void setCodEstadoCreditoCliente(Long codEstadoCreditoCliente) { this.codEstadoCreditoCliente = codEstadoCreditoCliente; }

    public Integer getEstadoHipotecario() { return estadoHipotecario; }
    public void setEstadoHipotecario(Integer estadoHipotecario) { this.estadoHipotecario = estadoHipotecario; }

    public Integer getEstadoConsumo() { return estadoConsumo; }
    public void setEstadoConsumo(Integer estadoConsumo) { this.estadoConsumo = estadoConsumo; }

    public Integer getEstadoAutomotriz() { return estadoAutomotriz; }
    public void setEstadoAutomotriz(Integer estadoAutomotriz) { this.estadoAutomotriz = estadoAutomotriz; }

    public Integer getEstadoEmergencia() { return estadoEmergencia; }
    public void setEstadoEmergencia(Integer estadoEmergencia) { this.estadoEmergencia = estadoEmergencia; }

    public Integer getEstadoArancel() { return estadoArancel; }
    public void setEstadoArancel(Integer estadoArancel) { this.estadoArancel = estadoArancel; }

    public Long getNroCliente() { return nroCliente; }
    public void setNroCliente(Long nroCliente) { this.nroCliente = nroCliente; }
}