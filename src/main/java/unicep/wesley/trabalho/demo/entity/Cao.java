package unicep.wesley.trabalho.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "caes")
public class Cao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String raca;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private String porte;

    @Column(nullable = false)
    private String temperamento;

    @Column(nullable = false)
    private Boolean disponivelParaAdocao = true;

    @Column(length = 1000)
    private String descricao;
} 