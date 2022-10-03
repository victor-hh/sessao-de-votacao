package com.haberkamp.sessaodevotacao.bootstrap;


import com.haberkamp.sessaodevotacao.dto.PautaRequestDTO;
import com.haberkamp.sessaodevotacao.entity.Pauta;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PautaBootstrap {

    public Pauta getPautaEntity() {
        return Pauta.builder()
                .tema("test")
                .build();
    }

    public PautaRequestDTO getPautaDTO() {
        return PautaRequestDTO.builder()
                .tema("test")
                .build();
    }

    public PautaRequestDTO getAbrirPautaDTO() {
        return PautaRequestDTO.builder()
                .id(1L)
                .tempoAbertoEmMinutos(5L)
                .build();
    }

    public PautaRequestDTO getAbrirPautaDTO(Long pautaId) {
        return PautaRequestDTO.builder()
                .id(pautaId)
                .tempoAbertoEmMinutos(5L)
                .build();
    }

}
