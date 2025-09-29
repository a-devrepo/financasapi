package br.com.nca.financasapi.application;

import br.com.nca.financasapi.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.nca.financasapi.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.nca.financasapi.domain.interfaces.MovimentacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/movimentacoes")
public class MovimentacoesController {

    private final MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CriarMovimentacaoRequest request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable UUID id, @RequestBody AlterarMovimentacaoRequest request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{dataMin}/{dataMax}")
    public ResponseEntity<?> get(@PathVariable String dataMin, @PathVariable String dataMax) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }
}