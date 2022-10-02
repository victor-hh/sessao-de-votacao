package com.haberkamp.sessaodevotacao.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tema;

    @Column
    private LocalDateTime horarioInicio;

    @Column
    private LocalDateTime horarioFim;

}
