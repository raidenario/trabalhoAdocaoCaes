package unicep.wesley.trabalho.demo.service;

import unicep.wesley.trabalho.demo.entity.Adocao;
import unicep.wesley.trabalho.demo.entity.Cao;
import unicep.wesley.trabalho.demo.entity.StatusAdocao;
import unicep.wesley.trabalho.demo.repository.AdocaoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdocaoService {
    private final AdocaoRepository adocaoRepository;
    private final CaoService caoService;

    public AdocaoService(AdocaoRepository adocaoRepository, CaoService caoService) {
        this.adocaoRepository = adocaoRepository;
        this.caoService = caoService;
    }

    public Adocao agendarAdocao(Adocao adocao) {
        Cao cao = caoService.buscarPorId(adocao.getCao().getId());
        if (!cao.getDisponivelParaAdocao()) {
            throw new RuntimeException("Cão não está disponível para adoção");
        }
        caoService.atualizarDisponibilidade(cao.getId(), false);
        return adocaoRepository.save(adocao);
    }

    public List<Adocao> listarAdocoes() {
        return adocaoRepository.findAll();
    }

    public void cancelarAdocao(Long id) {
        Adocao adocao = adocaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adoção não encontrada"));
        adocao.setStatus(StatusAdocao.CANCELADA);
        caoService.atualizarDisponibilidade(adocao.getCao().getId(), true);
        adocaoRepository.save(adocao);
    }

    public void concluirAdocao(Long id) {
        Adocao adocao = adocaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adoção não encontrada"));
        adocao.setStatus(StatusAdocao.CONCLUIDA);
        adocaoRepository.save(adocao);
    }
} 