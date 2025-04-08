package unicep.wesley.trabalho.demo.service;

import unicep.wesley.trabalho.demo.entity.Cao;
import unicep.wesley.trabalho.demo.repository.CaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CaoService {
    private final CaoRepository caoRepository;

    public CaoService(CaoRepository caoRepository) {
        this.caoRepository = caoRepository;
    }

    public Cao cadastrarCao(Cao cao) {
        return caoRepository.save(cao);
    }

    public List<Cao> listarCaesDisponiveis() {
        return caoRepository.findByDisponivelParaAdocaoTrue();
    }

    public Cao buscarPorId(Long id) {
        return caoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cão não encontrado"));
    }

    public void atualizarDisponibilidade(Long id, boolean disponivel) {
        Cao cao = buscarPorId(id);
        cao.setDisponivelParaAdocao(disponivel);
        caoRepository.save(cao);
    }
} 