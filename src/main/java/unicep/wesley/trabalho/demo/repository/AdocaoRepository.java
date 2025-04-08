package unicep.wesley.trabalho.demo.repository;

import unicep.wesley.trabalho.demo.entity.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {
    List<Adocao> findByCaoId(Long caoId);
} 