package br.com.nca.financasapi.infrastructure.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RabbitMQWorker {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQWorker.class);

    @RabbitListener(queues = "financas")
    public void receive(@Payload String message) {
            logger.info("Mensagem lida da fila em [{}]: {}",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                    message);
    }
}