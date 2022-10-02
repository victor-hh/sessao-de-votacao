package com.haberkamp.sessaodevotacao.bootstrap;

import com.haberkamp.sessaodevotacao.dto.VotoDTO;
import com.haberkamp.sessaodevotacao.dto.VotoEnum;
import com.haberkamp.sessaodevotacao.entity.Voto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VotoBootstrap {

    public Voto getEntity() {
        return Voto.builder()
                .pautaId(1L)
                .associadoId(1L)
                .voto("Sim")
                .build();
    }


    public VotoDTO getDto(Long pautaId) {
        return VotoDTO.builder()
                .pautaId(pautaId)
                .associadoId(1L)
                .voto(VotoEnum.Sim)
                .build();
    }

}
