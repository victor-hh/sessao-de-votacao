package com.haberkamp.sessaodevotacao.service.impl;

import com.haberkamp.sessaodevotacao.dto.ContagemVotosDTO;
import com.haberkamp.sessaodevotacao.dto.VotoDTO;
import com.haberkamp.sessaodevotacao.entity.Voto;
import com.haberkamp.sessaodevotacao.exceptions.BusinessException;
import com.haberkamp.sessaodevotacao.mapper.VotoMapper;
import com.haberkamp.sessaodevotacao.repository.VotoRepository;
import com.haberkamp.sessaodevotacao.service.PautaService;
import com.haberkamp.sessaodevotacao.service.VotoService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotoServiceImpl implements VotoService {

    private VotoMapper mapper = Mappers.getMapper(VotoMapper.class);

    @Autowired
    private VotoRepository repository;

    @Autowired
    private PautaService pautaService;

    @Override
    public VotoDTO save(VotoDTO voto) throws Exception {
        if (pautaService.isPautaAberta(voto.getPautaId())) {

            Optional<Voto> entity = repository.findById(mapper.getId(voto));

            if (entity.isPresent()) {
                throw new BusinessException("O associado já votou nesta pauta");
            }

            return mapper.toDto(repository.save(mapper.toEntity(voto)));
        }
        throw new BusinessException("A pauta esta fechada");
    }

    @Override
    public ContagemVotosDTO contarVotos(Long pautaId) {
        List<ContagemVotosDTO> votosApurados = repository.contarVotos(pautaId);
        return votosApurados.get(0);
    }


}
