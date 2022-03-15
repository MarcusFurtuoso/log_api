package com.log.logapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.log.logapi.assembler.OcorrenciaMapper;
import com.log.logapi.domain.model.Entrega;
import com.log.logapi.domain.model.Ocorrencia;
import com.log.logapi.domain.service.BuscaEntregaService;
import com.log.logapi.domain.service.RegistroOcorrenciaService;
import com.log.logapi.model.OcorrenciaModel;
import com.log.logapi.model.input.OcorrenciaInput;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
    

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                    .registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
    }
}
