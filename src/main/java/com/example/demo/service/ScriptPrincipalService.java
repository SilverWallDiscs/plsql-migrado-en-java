package com.example.demo.service;

import com.example.demo.entity.MontoIngreso;
import com.example.demo.repository.EstadoCreditoClienteRepository;
import com.example.demo.repository.MontoIngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScriptPrincipalService {

    @Autowired
    private MontoIngresoRepository montoIngresoRepository;

    @Autowired
    private EstadoCreditoClienteRepository estadoCreditoClienteRepository;

    @Autowired
    private InsercionTablasService insercionTablasService;

    @Autowired
    private ValidacionCreditosService validacionCreditosService;

    public ResultadoProceso ejecutarProceso() {  // Cambia el retorno a un objeto personalizado
        List<String> logs = new ArrayList<>();
        try {
            logs.add("Iniciando proceso de validación de créditos...");
            for (MontoIngreso mi : montoIngresoRepository.findAllWithJoins()) {
                Long ingreso = mi.getIngreso();
                Long codTipoCliente = mi.getCliente().getCodTipoCliente();
                Long nroCliente = mi.getNroCliente();

                logs.add("Procesando cliente " + nroCliente + " con ingreso " + ingreso + " y tipo " + codTipoCliente);

                Integer hipotecario = validacionCreditosService.creditoHipotecario(ingreso, codTipoCliente) ? 1 : 0;
                Integer consumo = validacionCreditosService.creditoConsumo(ingreso) ? 1 : 0;
                Integer automotriz = validacionCreditosService.creditoAutomotriz(ingreso, codTipoCliente) ? 1 : 0;
                Integer emergencia = validacionCreditosService.creditoEmergencia(ingreso, codTipoCliente) ? 1 : 0;
                Integer arancel = validacionCreditosService.creditoPagoArancel(ingreso, codTipoCliente) ? 1 : 0;

                logs.add("Validaciones: Hipotecario=" + hipotecario + ", Consumo=" + consumo + ", Automotriz=" + automotriz + ", Emergencia=" + emergencia + ", Arancel=" + arancel);

                if (!estadoCreditoClienteRepository.existsByNroCliente(nroCliente)) {
                    insercionTablasService.insertarEstadoCreditoCliente(nroCliente, hipotecario, consumo, automotriz, emergencia, arancel);
                    logs.add("Insertado estado de crédito para cliente " + nroCliente);
                } else {
                    logs.add("Cliente " + nroCliente + " ya tiene estado de crédito, omitiendo inserción");
                }
            }
            logs.add("Proceso completado exitosamente.");
            return new ResultadoProceso("Proceso completado exitosamente.", logs);
        } catch (Exception e) {
            logs.add("Error: " + e.getMessage());
            return new ResultadoProceso("Error: " + e.getMessage(), logs);
        }
    }

    // Clase interna para el resultado
    public static class ResultadoProceso {
        private String mensaje;
        private List<String> logs;

        public ResultadoProceso(String mensaje, List<String> logs) {
            this.mensaje = mensaje;
            this.logs = logs;
        }

        public String getMensaje() { return mensaje; }
        public List<String> getLogs() { return logs; }
    }
}