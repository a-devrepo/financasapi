package br.com.nca.financasapi.domain.collections;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection= "analises")
public class Analises {

    private UUID id;
    private LocalDateTime dataHora;
    private String pergunta;
    private String resposta;
    private String emailEnvio;
}
