package com.haberkamp.sessaodevotacao.controller.impl;

import com.haberkamp.sessaodevotacao.controller.PautaController;
import com.haberkamp.sessaodevotacao.dto.PautaRequestDTO;
import com.haberkamp.sessaodevotacao.dto.PautaResponseDTO;
import com.haberkamp.sessaodevotacao.entity.Pauta;
import com.haberkamp.sessaodevotacao.repository.PautaRepository;
import com.haberkamp.sessaodevotacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pauta")
public class PautaControllerImpl implements PautaController {

    @Autowired
    private PautaService service;

    @Override
    @PostMapping(value = "/cadastrar", produces = "application/json", consumes = "application/json")
    public PautaResponseDTO cadastrar(@RequestBody PautaRequestDTO pauta) {
        return service.save(pauta);
    }

    @Override
    @PutMapping(value = "/abrir", produces = "application/json", consumes = "application/json")
    public PautaResponseDTO abrirPauta(@RequestBody PautaRequestDTO pauta) {
        return service.abrirPauta(pauta);
    }

}
