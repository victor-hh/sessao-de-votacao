package com.haberkamp.sessaodevotacao.mapper;

import com.haberkamp.sessaodevotacao.dto.PautaRequestDTO;
import com.haberkamp.sessaodevotacao.dto.PautaResponseDTO;
import com.haberkamp.sessaodevotacao.entity.Pauta;
import org.mapstruct.Mapper;

@Mapper
public interface PautaMapper {

    PautaResponseDTO toDto(Pauta pauta);

    Pauta toEntity(PautaRequestDTO pauta);

}
