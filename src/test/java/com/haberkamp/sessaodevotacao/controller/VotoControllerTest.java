package com.haberkamp.sessaodevotacao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haberkamp.sessaodevotacao.bootstrap.PautaBootstrap;
import com.haberkamp.sessaodevotacao.bootstrap.VotoBootstrap;
import com.haberkamp.sessaodevotacao.entity.Pauta;
import com.haberkamp.sessaodevotacao.entity.Voto;
import com.haberkamp.sessaodevotacao.repository.PautaRepository;
import com.haberkamp.sessaodevotacao.repository.VotoRepository;
import com.haberkamp.sessaodevotacao.service.PautaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class VotoControllerTest {

    private final String BASE_URL = "/v1/voto";

    private ObjectMapper mapper;

    @Autowired
    private VotoRepository repository;

    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private PautaService pautaService;

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
        pautaRepository.deleteAll();
    }

    @Test
    void votarEmPautaAbertaERetornar202() throws Exception {

        Pauta pauta = pautaRepository.save(PautaBootstrap.getPautaEntity());
        pautaService.abrirPauta(PautaBootstrap.getAbrirPautaDTO(pauta.getId()));

        mapper = new ObjectMapper();

        URI uri = new URI(BASE_URL + "/votar");

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(VotoBootstrap.getDto(pauta.getId())))
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(202)
        );

    }

    @Test
    void contaVotosERetorna200() throws Exception {

        Pauta pauta = pautaRepository.save(PautaBootstrap.getPautaEntity());
        pautaService.abrirPauta(PautaBootstrap.getAbrirPautaDTO(pauta.getId()));
        repository.save(new Voto(pauta.getId(), 1L,  "Sim" ));
        repository.save(new Voto(pauta.getId(), 2L,  "Sim" ));
        repository.save(new Voto(pauta.getId(), 3L,  "Sim" ));
        repository.save(new Voto(pauta.getId(), 4L,  "Não" ));
        repository.save(new Voto(pauta.getId(), 5L,  "Não" ));

        mapper = new ObjectMapper();

        URI uri = new URI(BASE_URL + "/contar/" + pauta.getId());

        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(200)
        );

    }

}
