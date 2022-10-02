package com.haberkamp.sessaodevotacao.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotoId implements Serializable {

    private Long pautaId;
    private Long associadoId;

}


