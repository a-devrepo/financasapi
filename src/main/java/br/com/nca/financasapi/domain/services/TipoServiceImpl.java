package br.com.nca.financasapi.domain.services;

import br.com.nca.financasapi.domain.dtos.responses.ConsultarTipoResponse;
import br.com.nca.financasapi.domain.interfaces.TipoService;
import br.com.nca.financasapi.infrastructure.repositories.TipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TipoServiceImpl implements TipoService {

    private final TipoRepository tipoRepository;

    @Override
    public List<ConsultarTipoResponse> consultar() {

        var lista = tipoRepository.findAll();

        var resultado = new ArrayList<ConsultarTipoResponse>();

        for (var tipo : lista) {
            var dto = new ConsultarTipoResponse(tipo.getId(), tipo.getNome());
            resultado.add(dto);
        }
        return resultado;
    }
}
