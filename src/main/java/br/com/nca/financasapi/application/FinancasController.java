package br.com.nca.financasapi.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/financas")
public class FinancasController {

    private static final Logger logger = LoggerFactory.getLogger(FinancasController.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public FinancasController(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @PostMapping("/analise")
    public ResponseEntity<?> processarAnalise(){

        var mensagem = """
                Solicitação de análise financeira.
                """;
        rabbitTemplate.convertAndSend(queue.getName(), mensagem);
        logger.info("Mensagem enviada para fila com sucesso!");
        return ResponseEntity.ok().body("Solicitação de análise financeira realizada com sucesso!");
    }
}