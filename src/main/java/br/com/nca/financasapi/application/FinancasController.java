package br.com.nca.financasapi.application;

import br.com.nca.financasapi.domain.dtos.AnaliseRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/financas")
public class FinancasController {

    @PostMapping("/analise")
    public ResponseEntity<?> processarAnalise(@RequestBody AnaliseRequestDTO dto){
        return ResponseEntity.ok().body("Solicitação de análise financeira realizada com sucesso!");
    }
}