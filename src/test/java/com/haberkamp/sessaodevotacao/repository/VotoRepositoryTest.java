package com.haberkamp.sessaodevotacao.repository;

import com.haberkamp.sessaodevotacao.bootstrap.VotoBootstrap;
import com.haberkamp.sessaodevotacao.dto.ContagemVotosDTO;
import com.haberkamp.sessaodevotacao.entity.Voto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class VotoRepositoryTest {

    @Autowired
    private VotoRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void salvaNovoVoto() {
        repository.save(VotoBootstrap.getEntity());
        List<Voto> votos = repository.findAll();
        Assertions.assertEquals(1L, votos.size());
    }

    @Test
    void salvaVotosEConta() {
        repository.save(new Voto(1L, 1L,  "Sim" ));
        repository.save(new Voto(1L, 2L,  "Sim" ));
        repository.save(new Voto(1L, 3L,  "Sim" ));
        repository.save(new Voto(1L, 4L,  "Não" ));
        repository.save(new Voto(1L, 5L,  "Não" ));

        ContagemVotosDTO apuracao = repository.contarVotos(1L).get(0);

        Assertions.assertEquals(3, apuracao.getSim());
        Assertions.assertEquals(2, apuracao.getNao());

    }

}
