package br.com.lucas.pixjp_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_bilhete")
public class Bilhete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero", nullable = true)
    private String numero;
    @Column(name = "bilhete_premiado", nullable = false)
    private Boolean premiado;
    @Column(name = "data_compra", nullable = false)
    private LocalDate dataCompra;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
