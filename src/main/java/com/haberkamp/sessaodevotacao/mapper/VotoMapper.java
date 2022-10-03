package com.haberkamp.sessaodevotacao.mapper;

import com.haberkamp.sessaodevotacao.dto.VotoDTO;
import com.haberkamp.sessaodevotacao.entity.Voto;
import com.haberkamp.sessaodevotacao.entity.VotoId;
import org.mapstruct.Mapper;

@Mapper
public interface VotoMapper {

    Voto toEntity(VotoDTO voto);

    VotoDTO toDto(Voto voto);

    VotoId getId(VotoDTO voto);

}
