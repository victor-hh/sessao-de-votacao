package com.haberkamp.sessaodevotacao.repository;

import com.haberkamp.sessaodevotacao.dto.ContagemVotosDTO;
import com.haberkamp.sessaodevotacao.entity.Voto;
import com.haberkamp.sessaodevotacao.entity.VotoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, VotoId> {

    @Query(value = """
                select 
                    pautaId as pautaId,
                    (select 
                        count (*) 
                    from 
                        Voto
                    where 
                        pautaId = :pautaId
                        and voto = 'Sim' 
                    ) as sim,
                    (select 
                        count (*) 
                    from 
                        Voto 
                    where 
                        pautaId = :pautaId
                        and voto = 'Não' 
                    ) as nao
                from
                    Voto
                where
                    pautaId = :pautaId
            """)
    List<ContagemVotosDTO> contarVotos(Long pautaId);

}
