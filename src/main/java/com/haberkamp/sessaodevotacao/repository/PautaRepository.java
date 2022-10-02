package com.haberkamp.sessaodevotacao.repository;

import com.haberkamp.sessaodevotacao.entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
}
