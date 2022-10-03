package com.haberkamp.sessaodevotacao.controller;

import com.haberkamp.sessaodevotacao.dto.ContagemVotosDTO;
import com.haberkamp.sessaodevotacao.dto.VotoDTO;
import com.haberkamp.sessaodevotacao.entity.Voto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VotoController {

    ResponseEntity<VotoDTO> votar(VotoDTO voto) throws Exception;

    ResponseEntity<ContagemVotosDTO> obterContagemVotos(Long pautaId);

}
