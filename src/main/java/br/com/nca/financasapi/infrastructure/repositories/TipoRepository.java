package br.com.nca.financasapi.infrastructure.repositories;

import br.com.nca.financasapi.domain.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoRepository extends JpaRepository<Tipo, UUID> {
}
