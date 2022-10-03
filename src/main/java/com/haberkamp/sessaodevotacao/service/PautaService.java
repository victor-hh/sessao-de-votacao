package com.haberkamp.sessaodevotacao.service;

import com.haberkamp.sessaodevotacao.dto.PautaRequestDTO;
import com.haberkamp.sessaodevotacao.dto.PautaResponseDTO;

public interface PautaService {

    PautaResponseDTO save(PautaRequestDTO pauta);

    PautaResponseDTO abrirPauta(PautaRequestDTO pauta);

    Boolean isPautaAberta(Long pautaId);

}
