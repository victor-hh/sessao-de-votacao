package com.haberkamp.sessaodevotacao.repository;

import com.haberkamp.sessaodevotacao.bootstrap.PautaBootstrap;
import com.haberkamp.sessaodevotacao.entity.Pauta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class PautaRepositoryTest {

    @Autowired
    private PautaRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void cadastraPauta() {
        repository.save(PautaBootstrap.getPautaEntity());
        List<Pauta> pautasSalvas = repository.findAll();
        Assertions.assertEquals(1L, pautasSalvas.size());
        Assertions.assertEquals("test", pautasSalvas.get(0).getTema());
    }

}
