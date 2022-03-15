package com.log.logapi.domain.service;

import com.log.logapi.domain.exception.EntidadeNaoEncontradaException;
import com.log.logapi.domain.model.Entrega;
import com.log.logapi.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
    
    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada!"));
    }

}
