package com.haberkamp.sessaodevotacao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(VotoId.class)
public class Voto {

    @Id
//    @Column(name ="pauta_id")
    private Long pautaId;

    @Id
    private Long associadoId;

    @Column(name = "voto", length = 3)
    private String voto;

}
