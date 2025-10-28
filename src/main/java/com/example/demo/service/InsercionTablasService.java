package com.example.demo.service;

import com.example.demo.entity.EstadoCreditoCliente;
import com.example.demo.entity.MontoIngreso;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.EstadoCreditoClienteRepository;
import com.example.demo.repository.MontoIngresoRepository;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsercionTablasService {

    @Autowired
    private MontoIngresoRepository montoIngresoRepository;

    @Autowired
    private EstadoCreditoClienteRepository estadoCreditoClienteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void insertarMontoIngreso(Long ingreso, Long nroCliente) {
        MontoIngreso mi = new MontoIngreso();
        mi.setIngreso(ingreso);
        
        Cliente cliente = clienteRepository.findById(nroCliente).orElse(null);
        if (cliente != null) {
            mi.setCliente(cliente);
            montoIngresoRepository.save(mi);
        } else {
            throw new IllegalArgumentException("Cliente with nroCliente " + nroCliente + " not found");
        }
    }

    // Método actualizado para coincidir con la llamada en ScriptPrincipalService
    public void insertarEstadoCreditoCliente(Long nroCliente, Integer hipotecario, Integer consumo, Integer automotriz, Integer emergencia, Integer arancel) {
        EstadoCreditoCliente ecc = new EstadoCreditoCliente();
        ecc.setNroCliente(nroCliente);
        ecc.setHipotecario(hipotecario);
        ecc.setConsumo(consumo);
        ecc.setAutomotriz(automotriz);
        ecc.setEmergencia(emergencia);
        ecc.setArancel(arancel);
        
        estadoCreditoClienteRepository.save(ecc);
    }
}