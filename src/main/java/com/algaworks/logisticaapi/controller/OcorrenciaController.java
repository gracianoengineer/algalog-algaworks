package com.algaworks.logisticaapi.controller;

import com.algaworks.logisticaapi.assembler.OcorrenciaAssembler;
import com.algaworks.logisticaapi.domain.model.Entrega;
import com.algaworks.logisticaapi.domain.model.Ocorrencia;
import com.algaworks.logisticaapi.domain.service.BuscaEntregaService;
import com.algaworks.logisticaapi.domain.service.RegistroOcorrenciaService;
import com.algaworks.logisticaapi.model.OcorrenciaModel;
import com.algaworks.logisticaapi.model.input.OcorrenciaInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }
}
