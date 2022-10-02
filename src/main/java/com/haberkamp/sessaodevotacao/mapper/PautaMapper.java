package com.haberkamp.sessaodevotacao.mapper;

import com.haberkamp.sessaodevotacao.dto.PautaDTO;
import com.haberkamp.sessaodevotacao.entity.Pauta;
import org.mapstruct.Mapper;

@Mapper
public interface PautaMapper {

    PautaDTO toDto(Pauta pauta);

    Pauta toEntity(PautaDTO pauta);

}
