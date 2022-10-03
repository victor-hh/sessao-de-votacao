package com.haberkamp.sessaodevotacao.service.impl;

import com.haberkamp.sessaodevotacao.dto.PautaRequestDTO;
import com.haberkamp.sessaodevotacao.dto.PautaResponseDTO;
import com.haberkamp.sessaodevotacao.entity.Pauta;
import com.haberkamp.sessaodevotacao.exceptions.BusinessException;
import com.haberkamp.sessaodevotacao.mapper.PautaMapper;
import com.haberkamp.sessaodevotacao.repository.PautaRepository;
import com.haberkamp.sessaodevotacao.service.PautaService;
import net.bytebuddy.asm.Advice;
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
    public PautaResponseDTO save(PautaRequestDTO pauta) {

        Pauta pautaEntity = mapper.toEntity(pauta);

        pautaEntity = repository.save(pautaEntity);

        PautaResponseDTO pautaDTO = mapper.toDto(pautaEntity);

        return pautaDTO;
    }

    @Override
    public PautaResponseDTO abrirPauta(PautaRequestDTO pauta) {

        if (pauta.getTempoAbertoEmMinutos() == null) {
            pauta.setTempoAbertoEmMinutos(1L);
        }

        if (isPautaAberta(pauta.getId())) {
            throw new BusinessException("A pauta já está aberta");
        }

        Pauta entity = repository.findById(pauta.getId()).orElseThrow(() -> new EntityNotFoundException("Pauta nao cadastrada"));

        entity.setHorarioInicio(LocalDateTime.now());
        entity.setHorarioFim(LocalDateTime.now().plusMinutes(pauta.getTempoAbertoEmMinutos()));

        return mapper.toDto(repository.save(entity));

    }

    @Override
    public Boolean isPautaAberta(Long pautaId) {
        Optional<Pauta> entity = repository.findById(pautaId);
        if (entity.isPresent()) {
            LocalDateTime horarioFim = entity.get().getHorarioFim();
            if (horarioFim == null) {
                return false;
            }
            return horarioFim.isAfter(LocalDateTime.now()) ? true : false;
        }
        throw new BusinessException("Pauta não cadastrada");
    }

}
