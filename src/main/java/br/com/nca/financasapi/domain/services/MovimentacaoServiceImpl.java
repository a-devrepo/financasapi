package br.com.nca.financasapi.domain.services;

import br.com.nca.financasapi.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.nca.financasapi.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.nca.financasapi.domain.dtos.responses.ConsultarMovimentacaoResponse;
import br.com.nca.financasapi.domain.interfaces.MovimentacaoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {
    @Override
    public ConsultarMovimentacaoResponse criar(CriarMovimentacaoRequest request) {
        return null;
    }

    @Override
    public ConsultarMovimentacaoResponse alterar(AlterarMovimentacaoRequest request) {
        return null;
    }

    @Override
    public ConsultarMovimentacaoResponse excluir(UUID id) {
        return null;
    }

    @Override
    public Page<ConsultarMovimentacaoResponse> consultar(LocalDate dataMin, LocalDate datamax, int page) {
        return null;
    }

    @Override
    public ConsultarMovimentacaoResponse obterPorId(UUID id) {
        return null;
    }
}
