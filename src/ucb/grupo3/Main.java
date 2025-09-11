package ucb.grupo3.application;

public class Main {
    public static void main(String[] args) {
        TarefaService service = new TarefaService();

        // Criar tarefas
        TarefaModel t1 = TarefaModel.criarTarefa(1, "Estudar Java", "Praticar POO");
        TarefaModel t2 = TarefaModel.criarTarefa(2, "Ir à academia", "Treino de pernas");

        service.adicionarTarefa(t1);
        service.adicionarTarefa(t2);

        // Visualizar tarefas
        System.out.println("=== Lista de Tarefas ===");
        for (TarefaModel t : service.getTarefas()) {
            TarefaVisualizacaoEdicao.visualizarTarefa(t);
        }

        // Editar tarefa
        TarefaVisualizacaoEdicao.editarTarefa(t1, "Estudar Java Avançado", "Focar em Collections");

        // Marcar tarefa como concluída
        TarefaGerenciamento.marcarTarefa(t2);

        // Excluir tarefa
        TarefaGerenciamento.excluirTarefa(service, 1);

        // Visualizar novamente
        System.out.println("\n=== Lista de Tarefas Atualizada ===");
        for (TarefaModel t : service.getTarefas()) {
            TarefaVisualizacaoEdicao.visualizarTarefa(t);
        }
    }
}