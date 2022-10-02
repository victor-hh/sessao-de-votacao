package com.haberkamp.sessaodevotacao.bootstrap;


import com.haberkamp.sessaodevotacao.dto.PautaDTO;
import com.haberkamp.sessaodevotacao.entity.Pauta;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PautaBootstrap {

    public Pauta getPautaEntity() {
        return Pauta.builder()
                .tema("test")
                .build();
    }

    public PautaDTO getPautaDTO() {
        return PautaDTO.builder()
                .tema("test")
                .build();
    }

    public PautaDTO getAbrirPautaDTO() {
        return PautaDTO.builder()
                .id(1L)
                .tempoAbertoEmMinutos(5L)
                .build();
    }

    public PautaDTO getAbrirPautaDTO(Long pautaId) {
        return PautaDTO.builder()
                .id(pautaId)
                .tempoAbertoEmMinutos(5L)
                .build();
    }

}
