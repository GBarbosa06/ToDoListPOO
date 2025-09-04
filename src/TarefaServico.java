import java.util.ArrayList;
import java.util.List;

public class TarefaServico {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int contadorID = 1;

    // 4 métodos por causa dos construtores recursivos na classe Tarefa
    public Tarefa criarTarefa() {
        Tarefa tarefa = new Tarefa(contadorID++);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criarTarefa(String titulo) {
        Tarefa tarefa = new Tarefa(contadorID++, titulo);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criarTarefa(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(contadorID++, titulo, descricao);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criarTarefa(String titulo, String descricao, boolean completa) {
        Tarefa tarefa = new Tarefa(contadorID++, titulo, descricao, completa);
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefa> listarTarefas(){

    }

    public Tarefa atualizarTarefa(Tarefa tarefa){

    }

    public void removerTarefa(){

    }
}
