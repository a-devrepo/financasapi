package br.com.nca.financasapi.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;
}