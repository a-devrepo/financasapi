package br.com.nca.financasapi.application;

import br.com.nca.financasapi.domain.interfaces.TipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tipos")
public class TiposController {

    private final TipoService tipoService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(tipoService.consultar());
    }
}