package br.com.nca.financasapi.domain.interfaces;

import br.com.nca.financasapi.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.nca.financasapi.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.nca.financasapi.domain.dtos.responses.ConsultarMovimentacaoResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.UUID;

public interface MovimentacaoService {

    ConsultarMovimentacaoResponse criar(CriarMovimentacaoRequest request);

    ConsultarMovimentacaoResponse alterar(AlterarMovimentacaoRequest request);

    ConsultarMovimentacaoResponse excluir(UUID id);

    Page<ConsultarMovimentacaoResponse> consultar(LocalDate dataMin, LocalDate datamax, int page);

    ConsultarMovimentacaoResponse obterPorId(UUID id);
}