package unicep.wesley.trabalho.demo.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import java.util.Scanner;

@ShellComponent
public class MenuInterativo {
    private final AdocaoShell adocaoShell;
    private final Scanner scanner;

    public MenuInterativo(AdocaoShell adocaoShell) {
        this.adocaoShell = adocaoShell;
        this.scanner = new Scanner(System.in);
    }

    @ShellMethod(key = "menu", value = "Inicia o menu interativo do programa")
    public void iniciarMenu() {
        boolean executando = true;
        
        while (executando) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Listar cães disponíveis");
            System.out.println("2. Cadastrar novo cão");
            System.out.println("3. Agendar adoção");
            System.out.println("4. Listar adoções");
            System.out.println("5. Cancelar adoção");
            System.out.println("6. Concluir adoção");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println(adocaoShell.listarCaes());
                    break;
                case 2:
                    cadastrarCaoInterativo();
                    break;
                case 3:
                    agendarAdocaoInterativo();
                    break;
                case 4:
                    System.out.println(adocaoShell.listarAdocoes());
                    break;
                case 5:
                    cancelarAdocaoInterativo();
                    break;
                case 6:
                    concluirAdocaoInterativo();
                    break;
                case 0:
                    executando = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void cadastrarCaoInterativo() {
        System.out.println("\n=== CADASTRO DE CÃO ===");
        System.out.print("Nome do cão: ");
        String nome = scanner.nextLine();
        
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Porte (Pequeno/Médio/Grande): ");
        String porte = scanner.nextLine();
        
        System.out.print("Temperamento: ");
        String temperamento = scanner.nextLine();
        
        System.out.print("Descrição (opcional): ");
        String descricao = scanner.nextLine();

        System.out.println(adocaoShell.cadastrarCao(nome, raca, idade, porte, temperamento, descricao));
    }

    private void agendarAdocaoInterativo() {
        System.out.println("\n=== AGENDAMENTO DE ADOÇÃO ===");
        System.out.print("ID do cão: ");
        Long caoId = scanner.nextLong();
        scanner.nextLine();
        
        System.out.print("Nome do adotante: ");
        String nomeAdotante = scanner.nextLine();
        
        System.out.print("CPF do adotante: ");
        String cpfAdotante = scanner.nextLine();
        
        System.out.print("Telefone do adotante: ");
        String telefoneAdotante = scanner.nextLine();
        
        System.out.print("Email do adotante: ");
        String emailAdotante = scanner.nextLine();
        
        System.out.print("Data e hora do agendamento (dd/MM/yyyy HH:mm): ");
        String dataAgendamento = scanner.nextLine();

        System.out.println(adocaoShell.agendarAdocao(caoId, nomeAdotante, cpfAdotante, 
            telefoneAdotante, emailAdotante, dataAgendamento));
    }

    private void cancelarAdocaoInterativo() {
        System.out.println("\n=== CANCELAMENTO DE ADOÇÃO ===");
        System.out.print("ID da adoção: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println(adocaoShell.cancelarAdocao(id));
    }

    private void concluirAdocaoInterativo() {
        System.out.println("\n=== CONCLUSÃO DE ADOÇÃO ===");
        System.out.print("ID da adoção: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println(adocaoShell.concluirAdocao(id));
    }
} 