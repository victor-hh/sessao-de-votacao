package com.haberkamp.sessaodevotacao.service.impl;

import com.haberkamp.sessaodevotacao.dto.ContagemVotosDTO;
import com.haberkamp.sessaodevotacao.dto.VotoDTO;
import com.haberkamp.sessaodevotacao.mapper.VotoMapper;
import com.haberkamp.sessaodevotacao.repository.VotoRepository;
import com.haberkamp.sessaodevotacao.service.PautaService;
import com.haberkamp.sessaodevotacao.service.VotoService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoServiceImpl implements VotoService {

    private VotoMapper mapper = Mappers.getMapper(VotoMapper.class);

    @Autowired
    private VotoRepository repository;

    @Autowired
    private PautaService pautaService;

    //todo: tem que melhorar MUITO esse método

    @Override
    public VotoDTO save(VotoDTO voto) throws Exception {
        if (pautaService.isPautaAberta(voto.getPautaId())) {
            return mapper.toDto(repository.save(mapper.toEntity(voto)));
        }
        throw new Exception("Erro");
    }

    @Override
    public ContagemVotosDTO contarVotos(Long pautaId) {
        List<ContagemVotosDTO> votosApurados = repository.contarVotos(pautaId);
        return votosApurados.get(0);
    }


}
