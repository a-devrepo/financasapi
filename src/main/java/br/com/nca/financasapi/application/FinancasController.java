package br.com.nca.financasapi.application;

import br.com.nca.financasapi.domain.dtos.requests.AnaliseFinanceiraRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/financas")
public class FinancasController {

    private static final Logger logger = LoggerFactory.getLogger(FinancasController.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper mapper;

    @PostMapping("/analise")
    public ResponseEntity<?> processarAnalise(@RequestBody AnaliseFinanceiraRequest request) throws Exception {

        var jsonRequest = mapper.writeValueAsString(request);

        rabbitTemplate.convertAndSend(queue.getName(), jsonRequest);

        logger.info("Mensagem enviada para fila com sucesso!");

        return ResponseEntity.ok().body("Solicitação de análise financeira realizada com sucesso!");
    }
}