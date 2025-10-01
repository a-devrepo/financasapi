package br.com.nca.financasapi.domain.services;

import br.com.nca.financasapi.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.nca.financasapi.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.nca.financasapi.domain.dtos.responses.ConsultarMovimentacaoResponse;
import br.com.nca.financasapi.domain.dtos.responses.ConsultarTipoResponse;
import br.com.nca.financasapi.domain.entities.Movimentacao;
import br.com.nca.financasapi.domain.entities.Tipo;
import br.com.nca.financasapi.domain.interfaces.MovimentacaoService;
import br.com.nca.financasapi.infrastructure.repositories.MovimentacaoRepository;
import br.com.nca.financasapi.infrastructure.repositories.TipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final TipoRepository tipoRepository;

    @Override
    public ConsultarMovimentacaoResponse criar(CriarMovimentacaoRequest request) {

        var movimentacao = new Movimentacao();
        movimentacao.setNome(request.nome());
        movimentacao.setData(LocalDate.parse(request.data()));
        movimentacao.setValor(BigDecimal.valueOf(request.valor()));

        var tipo = tipoRepository.findById(request.tipoId()).get();
        movimentacao.setTipo(tipo);

        movimentacaoRepository.save(movimentacao);

        return new ConsultarMovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getNome(),
                movimentacao.getData().toString(),
                movimentacao.getValor().doubleValue(),
                new ConsultarTipoResponse(movimentacao.getTipo().getId(),movimentacao.getTipo().getNome()));
    }

    @Override
    public ConsultarMovimentacaoResponse alterar(AlterarMovimentacaoRequest request) {

        var movimentacao = movimentacaoRepository.findById(request.id()).get();

        movimentacao.setNome(request.nome());
        movimentacao.setData(LocalDate.parse(request.data()));
        movimentacao.setValor(BigDecimal.valueOf(request.valor()));
        movimentacao.getTipo().setId(request.tipoId());

        movimentacaoRepository.save(movimentacao);

        return new ConsultarMovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getNome(),
                movimentacao.getData().toString(),
                movimentacao.getValor().doubleValue(),
                new ConsultarTipoResponse(movimentacao.getTipo().getId(), movimentacao.getTipo().getNome()));
    }

    @Override
    public ConsultarMovimentacaoResponse excluir(UUID id) {

        var movimentacao = movimentacaoRepository.findById(id).get();

        movimentacaoRepository.delete(movimentacao);

        return new ConsultarMovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getNome(),
                movimentacao.getData().toString(),
                movimentacao.getValor().doubleValue(),
                new ConsultarTipoResponse(movimentacao.getTipo().getId(), movimentacao.getTipo().getNome()));
    }

    @Override
    public Page<ConsultarMovimentacaoResponse> consultar(LocalDate dataMin, LocalDate dataMax, int page) {

        var pageable = PageRequest.of(page, 25);

        var movimentacoes = movimentacaoRepository.findByDatas(dataMin, dataMax, pageable);

        return movimentacoes.map(m -> new ConsultarMovimentacaoResponse(
                m.getId(),
                m.getNome(),
                m.getData().toString(),
                m.getValor().doubleValue(),
                new ConsultarTipoResponse(m.getTipo().getId(), m.getTipo().getNome())
        ));
    }

    @Override
    public ConsultarMovimentacaoResponse obterPorId(UUID id) {

        var movimentacao = movimentacaoRepository.findById(id).get();

        return new ConsultarMovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getNome(),
                movimentacao.getData().toString(),
                movimentacao.getValor().doubleValue(),
                new ConsultarTipoResponse(movimentacao.getTipo().getId(), movimentacao.getTipo().getNome()));
    }
}