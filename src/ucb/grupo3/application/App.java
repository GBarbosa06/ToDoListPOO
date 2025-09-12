package ucb.grupo3.application;

import ucb.grupo3.model.Tarefa;
import ucb.grupo3.service.TarefaServico;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Inicializa o objeto Scanner para ler a entrada do usuário a partir do console.
        Scanner sc = new Scanner(System.in);
        // Cria uma instância do serviço de tarefas para lidar com as operações.
        TarefaServico servico = new TarefaServico();
        // Variável de controle para manter o loop do menu ativo.
        boolean rodando = true;

        // Loop principal do menu. O programa continua a rodar até que a opção 0 seja escolhida.
        while (rodando) {
            System.out.println("\n=== MENU DE TAREFAS ===");
            System.out.println("1. Criar tarefa");
            System.out.println("2. Visualizar todas as tarefas");
            System.out.println("3. Visualizar tarefas pendentes");
            System.out.println("4. Visualizar tarefas concluídas");
            System.out.println("5. Atualizar tarefa");
            System.out.println("6. Marcar tarefa como concluída");
            System.out.println("7. Remover tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // Consome a quebra de linha pendente após a leitura do número.

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição (ou enter p/ manter vazio): ");
                    String descricao = sc.nextLine();
                    Tarefa nova = servico.criarTarefa(titulo, descricao);
                    System.out.println("Tarefa criada com ID " + nova.getId());
                }
                case 2 -> {
                    // Chama o método auxiliar para listar todas as tarefas retornadas pelo serviço.
                    listarTarefas(servico.visualizarTarefas());
                }
                case 3 -> {
                    // Filtra todas as tarefas para encontrar as que não estão completas (pendentes).
                    List<Tarefa> pendentes = servico.visualizarTarefas()
                            .stream().filter(t -> !t.isCompleta()).toList();
                    listarTarefas(pendentes);
                }
                case 4 -> {
                    // Filtra todas as tarefas para encontrar as que já foram concluídas.
                    List<Tarefa> concluidas = servico.visualizarTarefas()
                            .stream().filter(Tarefa::isCompleta).toList();
                    listarTarefas(concluidas);
                }
                case 5 -> {
                    System.out.print("ID da tarefa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo título (ou enter p/ manter): ");
                    String titulo = sc.nextLine();
                    // Se o usuário não inserir um novo título, o valor é mantido como null para não ser atualizado.
                    if (titulo.isBlank()) titulo = null;

                    System.out.print("Nova descrição (ou enter p/ manter): ");
                    String descricao = sc.nextLine();
                    // Se a descrição for vazia, o valor é mantido como null.
                    if (descricao.isBlank()) descricao = null;

                    System.out.print("Alterar status? (s/n): ");
                    String resp = sc.nextLine();
                    Boolean completa = null;
                    if (resp.equalsIgnoreCase("s")) {
                        System.out.print("Está concluída? (true/false): ");
                        completa = sc.nextBoolean();
                        sc.nextLine();
                    }

                    servico.atualizarTarefa(id, titulo, descricao, completa);
                    System.out.println("Tarefa atualizada (se encontrada).");
                }
                case 6 -> {
                    System.out.print("ID da tarefa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    servico.marcarTarefa(id);
                    System.out.println("Tarefa marcada como concluída.");
                }
                case 7 -> {
                    System.out.print("ID da tarefa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    servico.removerTarefa(id);
                    System.out.println("Tarefa removida (se encontrada).");
                }
                case 0 -> {
                    // Altera a variável de controle para sair do loop.
                    rodando = false;
                    System.out.println("Saindo do sistema...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }

        // Fecha o Scanner para liberar os recursos do sistema.
        sc.close();
    }

    /**
     * Método auxiliar para imprimir uma lista de tarefas no console.
     * <p>
     * Ele verifica se a lista está vazia e, se não estiver, itera sobre as tarefas
     * para imprimir seus detalhes formatados.
     * </p>
     *
     * @param tarefas A lista de objetos {@link Tarefa} a ser exibida.
     */
    private static void listarTarefas(List<Tarefa> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            for (Tarefa t : tarefas) {
                String tCompleta = t.isCompleta() ? "Sim" : "Não";
                System.out.println("ID: " + t.getId() +
                        " | Título: " + t.getTitulo() +
                        " | Descrição: " + t.getDescricao() +
                        " | Concluída: " + tCompleta +
                        " | Criada em: " + t.getDataAgora());
            }
        }
    }
}
