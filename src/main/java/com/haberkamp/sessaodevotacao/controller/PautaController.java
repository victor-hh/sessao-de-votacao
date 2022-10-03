package com.haberkamp.sessaodevotacao.controller;

import com.haberkamp.sessaodevotacao.dto.PautaRequestDTO;
import com.haberkamp.sessaodevotacao.dto.PautaResponseDTO;
import com.haberkamp.sessaodevotacao.entity.Pauta;

import java.util.List;

public interface PautaController {

    PautaResponseDTO cadastrar(PautaRequestDTO pauta);

    PautaResponseDTO abrirPauta(PautaRequestDTO pauta);

    List<Pauta> findAll();
}
