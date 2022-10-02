package com.haberkamp.sessaodevotacao.controller;

import com.haberkamp.sessaodevotacao.dto.PautaDTO;
import com.haberkamp.sessaodevotacao.entity.Pauta;

import java.util.List;

public interface PautaController {

    PautaDTO cadastrar(PautaDTO pauta);

    PautaDTO abrirPauta(PautaDTO pauta);

    List<Pauta> findAll();
}
