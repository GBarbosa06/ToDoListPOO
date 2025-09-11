package ucb.grupo3.service;

import ucb.grupo3.model.Tarefa;
import java.util.ArrayList;

public class TarefaServico {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private int contadorID = 1;

    // Criar tarefa
    public Tarefa criarTarefa(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(contadorID, titulo, descricao, false);
        contadorID++;
        tarefas.add(tarefa);
        return tarefa;
    }

    // Visualizar tarefas
    public ArrayList<Tarefa> visualizarTarefas() {
        return tarefas;
    }

    // Atualizar tarefa
    public void atualizarTarefa(int id, String novoTitulo, String novaDescricao, boolean completa) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.setTitulo(novoTitulo);
                tarefa.setDescricao(novaDescricao);
                tarefa.setCompleta(completa);
            }
        }
    }

    // Remover tarefa
    public void removerTarefa(int id) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId() == id) {
                tarefas.remove(i);
                break;
            }
        }
    }

    // Marcar tarefa como concluída
    public void marcarTarefa(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.setCompleta(true);
                break;
            }
        }
    }
}
