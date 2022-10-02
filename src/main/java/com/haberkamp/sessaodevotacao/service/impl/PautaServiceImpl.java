package com.haberkamp.sessaodevotacao.service.impl;

import com.haberkamp.sessaodevotacao.dto.PautaDTO;
import com.haberkamp.sessaodevotacao.entity.Pauta;
import com.haberkamp.sessaodevotacao.mapper.PautaMapper;
import com.haberkamp.sessaodevotacao.repository.PautaRepository;
import com.haberkamp.sessaodevotacao.service.PautaService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PautaServiceImpl implements PautaService {

    @Autowired
    private PautaRepository repository;

    private PautaMapper mapper = Mappers.getMapper(PautaMapper.class);

    @Override
    public PautaDTO save(PautaDTO pauta) {

        Pauta pautaEntity = mapper.toEntity(pauta);

        pautaEntity = repository.save(pautaEntity);

        PautaDTO pautaDTO = mapper.toDto(pautaEntity);

        return pautaDTO;
    }

    @Override
    public PautaDTO abrirPauta(PautaDTO pauta) {

        Pauta entity = repository.findById(pauta.getId()).orElseThrow(EntityNotFoundException::new);

        entity.setHorarioInicio(LocalDateTime.now());
        entity.setHorarioFim(LocalDateTime.now().plusMinutes(pauta.getTempoAbertoEmMinutos()));

        return mapper.toDto(repository.save(entity));

    }

    @Override
    public Boolean isPautaAberta(Long pautaId) {
        Optional<Pauta> entity = repository.findById(pautaId);
        if (entity.isPresent()) {
            return entity.get().getHorarioFim().isAfter(LocalDateTime.now()) ? true : false;
        }
        return false;
    }

}
