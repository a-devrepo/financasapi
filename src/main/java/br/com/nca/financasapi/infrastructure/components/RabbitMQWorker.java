package br.com.nca.financasapi.infrastructure.components;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RabbitMQWorker {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQWorker.class);

    private final OpenAIComponent openAIComponent;

    @RabbitListener(queues = "financas")
    public void receive(@Payload String message) {
        try{
            var resposta = openAIComponent.send(message);
            logger.info("Mensagem lida da fila: {}", resposta);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}