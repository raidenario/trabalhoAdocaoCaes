package unicep.wesley.trabalho.demo.shell;

import unicep.wesley.trabalho.demo.entity.Adocao;
import unicep.wesley.trabalho.demo.entity.Cao;
import unicep.wesley.trabalho.demo.service.AdocaoService;
import unicep.wesley.trabalho.demo.service.CaoService;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class AdocaoShell {
    private final CaoService caoService;
    private final AdocaoService adocaoService;

    public AdocaoShell(CaoService caoService, AdocaoService adocaoService) {
        this.caoService = caoService;
        this.adocaoService = adocaoService;
    }

    public String listarCaes() {
        List<Cao> caes = caoService.listarCaesDisponiveis();
        if (caes.isEmpty()) {
            return "Não há cães disponíveis para adoção no momento.";
        }
        StringBuilder sb = new StringBuilder("Cães disponíveis para adoção:\n");
        for (Cao cao : caes) {
            sb.append(String.format("ID: %d | Nome: %s | Raça: %s | Idade: %d | Porte: %s\n",
                    cao.getId(), cao.getNome(), cao.getRaca(), cao.getIdade(), cao.getPorte()));
        }
        return sb.toString();
    }

    public String cadastrarCao(String nome, String raca, Integer idade, String porte, String temperamento, String descricao) {
        Cao cao = new Cao();
        cao.setNome(nome);
        cao.setRaca(raca);
        cao.setIdade(idade);
        cao.setPorte(porte);
        cao.setTemperamento(temperamento);
        cao.setDescricao(descricao);
        cao.setDisponivelParaAdocao(true);

        caoService.cadastrarCao(cao);
        return "Cão cadastrado com sucesso!";
    }

    public String agendarAdocao(Long caoId, String nomeAdotante, String cpfAdotante, String telefoneAdotante, 
            String emailAdotante, String dataAgendamento) {
        try {
            Cao cao = caoService.buscarPorId(caoId);
            if (!cao.getDisponivelParaAdocao()) {
                return "Este cão não está disponível para adoção.";
            }

            Adocao adocao = new Adocao();
            adocao.setCao(cao);
            adocao.setNomeAdotante(nomeAdotante);
            adocao.setCpfAdotante(cpfAdotante);
            adocao.setTelefoneAdotante(telefoneAdotante);
            adocao.setEmailAdotante(emailAdotante);
            adocao.setDataAgendamento(LocalDateTime.parse(dataAgendamento,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

            adocaoService.agendarAdocao(adocao);
            return "Adoção agendada com sucesso!";
        } catch (Exception e) {
            return "Erro ao agendar adoção: " + e.getMessage();
        }
    }

    public String listarAdocoes() {
        List<Adocao> adocoes = adocaoService.listarAdocoes();
        if (adocoes.isEmpty()) {
            return "Não há adoções cadastradas.";
        }
        StringBuilder sb = new StringBuilder("Adoções:\n");
        for (Adocao adocao : adocoes) {
            sb.append(String.format("ID: %d | Cão: %s | Adotante: %s | Data: %s | Status: %s\n",
                    adocao.getId(),
                    adocao.getCao().getNome(),
                    adocao.getNomeAdotante(),
                    adocao.getDataAgendamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                    adocao.getStatus()));
        }
        return sb.toString();
    }

    public String cancelarAdocao(Long id) {
        try {
            adocaoService.cancelarAdocao(id);
            return "Adoção cancelada com sucesso!";
        } catch (Exception e) {
            return "Erro ao cancelar adoção: " + e.getMessage();
        }
    }

    public String concluirAdocao(Long id) {
        try {
            adocaoService.concluirAdocao(id);
            return "Adoção concluída com sucesso!";
        } catch (Exception e) {
            return "Erro ao concluir adoção: " + e.getMessage();
        }
    }
} 