package com.haberkamp.sessaodevotacao.controller.impl;

import com.haberkamp.sessaodevotacao.controller.VotoController;
import com.haberkamp.sessaodevotacao.dto.ContagemVotosDTO;
import com.haberkamp.sessaodevotacao.dto.VotoDTO;
import com.haberkamp.sessaodevotacao.entity.Voto;
import com.haberkamp.sessaodevotacao.repository.VotoRepository;
import com.haberkamp.sessaodevotacao.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/voto")
public class VotoControllerImpl implements VotoController {

    @Autowired
    private VotoService service;

    @Autowired
    private VotoRepository repository;

    @Override
    @PostMapping(value =  "/votar", produces = "application/json", consumes = "application/json")
    public ResponseEntity<VotoDTO> votar(@RequestBody VotoDTO voto) throws Exception {
        VotoDTO votoDTO = service.save(voto);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(votoDTO);

    }

    @Override
    @GetMapping("contar/{pautaId}")
    public ResponseEntity<ContagemVotosDTO> obterContagemVotos(@PathVariable Long pautaId) {
        ContagemVotosDTO resultadoApuracao = service.contarVotos(pautaId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(resultadoApuracao);
    }

    @Override
    @GetMapping("/findAll")
    public List<Voto> findAll() {
        return repository.findAll();
    }


}
