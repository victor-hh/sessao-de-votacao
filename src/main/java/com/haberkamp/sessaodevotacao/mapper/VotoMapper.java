package com.haberkamp.sessaodevotacao.mapper;

import com.haberkamp.sessaodevotacao.dto.VotoDTO;
import com.haberkamp.sessaodevotacao.entity.Voto;
import org.mapstruct.Mapper;

@Mapper
public interface VotoMapper {

    Voto toEntity(VotoDTO voto);

    VotoDTO toDto(Voto voto);

}
