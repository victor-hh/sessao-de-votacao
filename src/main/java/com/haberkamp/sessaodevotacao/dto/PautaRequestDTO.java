package com.haberkamp.sessaodevotacao.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class PautaDTO {

    private Long id;

    private String tema;

    private LocalDateTime horarioInicio;

    private LocalDateTime horarioFim;

    private Long tempoAbertoEmMinutos;

}
