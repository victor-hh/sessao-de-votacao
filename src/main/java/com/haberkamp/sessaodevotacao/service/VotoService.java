package com.haberkamp.sessaodevotacao.service;

import com.haberkamp.sessaodevotacao.dto.ContagemVotosDTO;
import com.haberkamp.sessaodevotacao.dto.VotoDTO;

public interface VotoService {

    VotoDTO save(VotoDTO voto) throws Exception;

    ContagemVotosDTO contarVotos(Long pautaId);

}
