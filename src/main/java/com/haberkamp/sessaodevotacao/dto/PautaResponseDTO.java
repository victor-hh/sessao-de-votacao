package com.haberkamp.sessaodevotacao.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PautaResponseDTO {

    private Long id;

    private String tema;

    private LocalDateTime horarioInicio;

    private LocalDateTime horarioFim;


}
