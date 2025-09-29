package br.com.nca.financasapi.domain.services;

import br.com.nca.financasapi.domain.dtos.responses.ConsultarTipoResponse;
import br.com.nca.financasapi.domain.interfaces.TipoService;

import java.util.List;

public class TipoServiceImpl implements TipoService {
    @Override
    public List<ConsultarTipoResponse> consultar() {
        return List.of();
    }
}
