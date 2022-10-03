package com.haberkamp.sessaodevotacao.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PautaRequestDTO {

    private Long id;

    private String tema;

    private Long tempoAbertoEmMinutos;

}
