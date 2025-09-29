package br.com.nca.financasapi.domain.dtos.responses;

import java.util.UUID;

public record ConsultarTipoResponse(
        UUID id,
        String nome
) { }
