package br.com.lucas.pixjp_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_sorteio")
public class Sorteio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_sorteio")
    private String numero;
    @Column(name = "data_sorteio", nullable = false)
    private LocalDate dataSorteio;
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;
    @Column(name = "data_final", nullable = false)
    private LocalDate dataFinal;


}
