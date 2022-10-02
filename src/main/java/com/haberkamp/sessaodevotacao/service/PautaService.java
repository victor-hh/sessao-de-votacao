package com.haberkamp.sessaodevotacao.service;

import com.haberkamp.sessaodevotacao.dto.PautaDTO;

public interface PautaService {

    PautaDTO save(PautaDTO pauta);

    PautaDTO abrirPauta(PautaDTO pauta);

    Boolean isPautaAberta(Long pautaId);

}
