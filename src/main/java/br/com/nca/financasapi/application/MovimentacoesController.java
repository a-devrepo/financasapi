package br.com.nca.financasapi.application;

import br.com.nca.financasapi.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.nca.financasapi.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.nca.financasapi.domain.dtos.responses.ConsultarMovimentacaoResponse;
import br.com.nca.financasapi.domain.interfaces.MovimentacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/movimentacoes")
public class MovimentacoesController {

    private final MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<ConsultarMovimentacaoResponse> post(@RequestBody CriarMovimentacaoRequest request) {
        var response = movimentacaoService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<ConsultarMovimentacaoResponse> put(@RequestBody AlterarMovimentacaoRequest request) {
        var response = movimentacaoService.alterar(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConsultarMovimentacaoResponse> delete(@PathVariable UUID id) {
        var response = movimentacaoService.excluir(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{dataMin}/{dataMax}/{page}")
    public ResponseEntity<Page<ConsultarMovimentacaoResponse>> get(
            @PathVariable String dataMin, @PathVariable String dataMax, @PathVariable int page) {
        var resultado = movimentacaoService.consultar(LocalDate.parse(dataMin), LocalDate.parse(dataMax), page);
        return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultarMovimentacaoResponse> get(@PathVariable UUID id) {
        var response = movimentacaoService.obterPorId(id);
        return ResponseEntity.ok().body(response);
    }
}