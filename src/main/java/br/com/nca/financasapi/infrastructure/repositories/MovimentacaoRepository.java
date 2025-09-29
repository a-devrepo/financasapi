package br.com.nca.financasapi.infrastructure.repositories;

import br.com.nca.financasapi.domain.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, UUID> {
}
