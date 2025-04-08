package unicep.wesley.trabalho.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "adocoes")
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cao_id", nullable = false)
    private Cao cao;

    @Column(nullable = false)
    private String nomeAdotante;

    @Column(nullable = false)
    private String cpfAdotante;

    @Column(nullable = false)
    private String telefoneAdotante;

    @Column(nullable = false)
    private String emailAdotante;

    @Column(nullable = false)
    private LocalDateTime dataAgendamento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusAdocao status = StatusAdocao.AGENDADA;
} 