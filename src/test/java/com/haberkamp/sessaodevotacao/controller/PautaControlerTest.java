package com.haberkamp.sessaodevotacao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haberkamp.sessaodevotacao.bootstrap.PautaBootstrap;
import com.haberkamp.sessaodevotacao.repository.PautaRepository;
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
import java.net.URISyntaxException;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class PautaControlerTest {

    private final String BASE_URL = "/v1/pauta";

    private ObjectMapper mapper;

    @Autowired
    private PautaRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        repository.save(PautaBootstrap.getPautaEntity());
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void cadastrarPauta() throws Exception {

        mapper = new ObjectMapper();

        URI uri = new URI(BASE_URL + "/cadastrar");

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(PautaBootstrap.getPautaDTO()))
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(200)
        );

    }

    @Test
    void abrirPauta() throws Exception {

        mapper = new ObjectMapper();

        URI uri = new URI(BASE_URL + "/abrir");

        mockMvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(PautaBootstrap.getAbrirPautaDTO()))
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(200)
        );

    }
}
