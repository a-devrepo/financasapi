package br.com.nca.financasapi.infrastructure.repositories;

import br.com.nca.financasapi.domain.entities.Movimentacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, UUID> {

    @Query("""
            SELECT m FROM Movimentacao m
            WHERE m.data BETWEEN :pDataMin AND :pDataMax ORDER BY m.data ASC
            """)
    Page<Movimentacao> findByDatas(
            @Param("pDataMin") LocalDate dataMin,
            @Param("pDataMax") LocalDate dataMax, Pageable pageable);
}
