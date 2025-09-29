package br.com.nca.financasapi.domain.dtos.responses;

import java.util.UUID;

public record ConsultarMovimentacaoResponse(
        UUID id,
        String nome,
        String data,
        Double valor,
        ConsultarTipoResponse tipo
) { }
