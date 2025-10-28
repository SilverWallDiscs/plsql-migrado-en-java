package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTADO_CREDITO_CLIENTE")
public class EstadoCreditoCliente {

    @Id
    @Column(name = "nro_cliente")
    private Long nroCliente;

    @Column(name = "hipotecario")
    private Integer hipotecario;

    @Column(name = "consumo")
    private Integer consumo;

    @Column(name = "automotriz")
    private Integer automotriz;

    @Column(name = "emergencia")
    private Integer emergencia;

    @Column(name = "arancel")
    private Integer arancel;

    // Getters
    public Long getNroCliente() {
        return nroCliente;
    }

    public Integer getHipotecario() {
        return hipotecario;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public Integer getAutomotriz() {
        return automotriz;
    }

    public Integer getEmergencia() {
        return emergencia;
    }

    public Integer getArancel() {
        return arancel;
    }

    // Setters (agregados para resolver los errores)
    public void setNroCliente(Long nroCliente) {
        this.nroCliente = nroCliente;
    }

    public void setHipotecario(Integer hipotecario) {
        this.hipotecario = hipotecario;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public void setAutomotriz(Integer automotriz) {
        this.automotriz = automotriz;
    }

    public void setEmergencia(Integer emergencia) {
        this.emergencia = emergencia;
    }

    public void setArancel(Integer arancel) {
        this.arancel = arancel;
    }
}