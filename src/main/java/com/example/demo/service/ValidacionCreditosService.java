package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ValidacionCreditosService {

    public boolean creditoHipotecario(Long ingreso, Long codTipoCliente) {
        return ingreso >= 1500000 && (codTipoCliente == 1 || codTipoCliente == 2);
    }

    public boolean creditoConsumo(Long ingreso) {
        return ingreso >= 900000;
    }

    public boolean creditoAutomotriz(Long ingreso, Long codTipoCliente) {
        return ingreso >= 900000 && (codTipoCliente == 1 || codTipoCliente == 2);
    }

    public boolean creditoEmergencia(Long ingreso, Long codTipoCliente) {
        return (ingreso >= 900000 && (codTipoCliente == 1 || codTipoCliente == 2)) ||
               (ingreso >= 150000 && codTipoCliente == 3);
    }

    public boolean creditoPagoArancel(Long ingreso, Long codTipoCliente) {
        return ingreso >= 900000 && (codTipoCliente == 1 || codTipoCliente == 2);
    }
}