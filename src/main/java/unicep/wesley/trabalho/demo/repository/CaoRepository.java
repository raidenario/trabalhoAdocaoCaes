package unicep.wesley.trabalho.demo.repository;

import unicep.wesley.trabalho.demo.entity.Cao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CaoRepository extends JpaRepository<Cao, Long> {
    List<Cao> findByDisponivelParaAdocaoTrue();
} 