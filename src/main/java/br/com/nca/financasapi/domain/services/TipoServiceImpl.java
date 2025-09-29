package br.com.nca.financasapi.domain.services;

import br.com.nca.financasapi.domain.dtos.responses.ConsultarTipoResponse;
import br.com.nca.financasapi.domain.interfaces.TipoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {
    @Override
    public List<ConsultarTipoResponse> consultar() {
        return List.of();
    }
}
