package br.com.nca.financasapi.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/financas")
public class FinancasController {

    @PostMapping("/analise")
    public ResponseEntity<?> processarAnalise(){
        return ResponseEntity.ok().body("Solicitação de análise financeira realizada com sucesso!");
    }
}