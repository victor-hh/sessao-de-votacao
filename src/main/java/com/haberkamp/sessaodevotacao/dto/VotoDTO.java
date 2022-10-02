package com.haberkamp.sessaodevotacao.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoDTO {

    private Long pautaId;

    private Long associadoId;

    private VotoEnum voto;

}
