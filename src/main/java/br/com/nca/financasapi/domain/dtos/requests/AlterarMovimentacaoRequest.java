package br.com.nca.financasapi.domain.dtos.requests;

import java.util.UUID;

public record AlterarMovimentacaoRequest(
        UUID id,
        String nome,
        String data,
        Double valor,
        UUID tipoId
) { }
