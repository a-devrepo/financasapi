package br.com.nca.financasapi.infrastructure.repositories;

import br.com.nca.financasapi.domain.collections.Analises;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnalisesRepository extends MongoRepository<Analises, UUID> {

}
