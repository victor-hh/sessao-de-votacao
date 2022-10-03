package com.haberkamp.sessaodevotacao.service;

import com.haberkamp.sessaodevotacao.bootstrap.PautaBootstrap;
import com.haberkamp.sessaodevotacao.bootstrap.VotoBootstrap;
import com.haberkamp.sessaodevotacao.dto.ContagemVotosDTO;
import com.haberkamp.sessaodevotacao.dto.PautaRequestDTO;
import com.haberkamp.sessaodevotacao.dto.PautaResponseDTO;
import com.haberkamp.sessaodevotacao.entity.Voto;
import com.haberkamp.sessaodevotacao.repository.VotoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class VotoServiceTest {

    @Autowired
    private VotoService service;

    @Autowired
    private PautaService pautaService;

    @Autowired
    private VotoRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void salvaNovoVotoEmPautaExistente() throws Exception {
        PautaResponseDTO pauta = pautaService.save(PautaBootstrap.getPautaDTO());
        pautaService.abrirPauta(PautaBootstrap.getAbrirPautaDTO(pauta.getId()));

        service.save(VotoBootstrap.getDto(pauta.getId()));
        List<Voto> votos = repository.findAll();
        Assertions.assertEquals(1L, votos.size());
        Assertions.assertEquals(1L, votos.get(0).getAssociadoId());
        Assertions.assertEquals("Sim", votos.get(0).getVoto());
    }

    @Test
    void salvaVotosEConta() {
        repository.save(new Voto(1L, 1L,  "Sim" ));
        repository.save(new Voto(1L, 2L,  "Sim" ));
        repository.save(new Voto(1L, 3L,  "Sim" ));
        repository.save(new Voto(1L, 4L,  "Não" ));
        repository.save(new Voto(1L, 5L,  "Não" ));

        ContagemVotosDTO apuracao = service.contarVotos(1L);

        Assertions.assertEquals(3, apuracao.getSim());
        Assertions.assertEquals(2, apuracao.getNao());
    }

}
