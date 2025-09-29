package br.com.nca.financasapi.domain.interfaces;

import br.com.nca.financasapi.domain.dtos.responses.ConsultarTipoResponse;

import java.util.List;

public interface TipoService {

    List<ConsultarTipoResponse> consultar();
}
