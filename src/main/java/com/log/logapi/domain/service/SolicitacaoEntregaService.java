package com.log.logapi.domain.service;

import java.time.LocalDateTime;

import com.log.logapi.domain.model.Cliente;
import com.log.logapi.domain.model.Entrega;
import com.log.logapi.domain.model.StatusEntrega;
import com.log.logapi.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
    
    private DomainClienteService domainClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = domainClienteService.solicitar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        
        return entregaRepository.save(entrega);
    }
}
