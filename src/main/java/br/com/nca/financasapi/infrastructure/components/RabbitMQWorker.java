package br.com.nca.financasapi.infrastructure.components;

import br.com.nca.financasapi.domain.collections.Analises;
import br.com.nca.financasapi.domain.dtos.requests.AnaliseFinanceiraRequest;
import br.com.nca.financasapi.infrastructure.repositories.AnalisesRepository;
import br.com.nca.financasapi.infrastructure.repositories.MovimentacaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class RabbitMQWorker {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQWorker.class);

    private final OpenAIComponent openAIComponent;

    private final AnalisesRepository analisesRepository;

    private final MovimentacaoRepository movimentacaoRepository;

    private final ObjectMapper mapper;

    private final JavaMailSender mailSender;

    @RabbitListener(queues = "financas")
    public void receive(@Payload String message) {
        try{
            var request = mapper.readValue(message, AnaliseFinanceiraRequest.class);

            var movimentacoes = movimentacaoRepository.findAll();

            var prompt = """
                        Você é especializado em realizar análises financeiras. Abaixo está um JSON com as
                        movimentações do sistema. Faça a análise conforme pedido (não gere respostas para
                        nada que não esteja relacionado a análise financeira).
                    """;

            var json = mapper.writeValueAsString(movimentacoes);

            var texto = prompt+"\n"+ json+"\n"+request.perguntaAnalise();

            var resposta = openAIComponent.send(texto);

            logger.info("Mensagem lida da fila");

            var analises = new Analises();
            analises.setId(UUID.randomUUID());
            analises.setDataHora(LocalDateTime.now());
            analises.setPergunta(request.perguntaAnalise());
            analises.setResposta(resposta);

            analisesRepository.save(analises);

            logger.info("Mensagem gravada no banco");

            var mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("nao-responda@email.com");
            mailMessage.setTo(request.emailNotificacao());
            mailMessage.setSubject("Análise financeira gerada em: " + LocalDateTime.now());
            mailMessage.setText(resposta);

            mailSender.send(mailMessage);

            logger.info("Mensagem enviada por email");

        } catch (RuntimeException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}