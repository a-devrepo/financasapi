package br.com.nca.financasapi.domain.dtos.requests;

public record AnaliseFinanceiraRequest(
        String perguntaAnalise,
        String emailNotificacao
) { }
