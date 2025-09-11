package ucb.grupo3.service;

import ucb.grupo3.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaServico {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int contadorID = 1;

    // 4 métodos por causa dos construtores recursivos na classe main.java.ucb.grupo3.model.Tarefa

    public Tarefa buscarTarefa(int IdBuscado) {
         for (Tarefa tarefa: tarefas){
             if(tarefa.getId() == IdBuscado) {
                 return tarefa;
             }
         }
        return null;
    }


    public Tarefa criarTarefa(String titulo, String descricao, boolean completa) {
        Tarefa tarefa = new Tarefa(contadorID++, titulo, descricao, completa);
        tarefas.add(tarefa);
        return tarefa;
    }
        
    public List<Tarefa> visualizarTarefa() {
        return new ArrayList<>(tarefas);
    }

     public void atualizarTarefa(int id, String novoTitulo, String novaDescricao, boolean novaCompleta) {
            for (Tarefa tarefa : tarefas) {
                if (tarefa.getId() == id) { 
                    if (novoTitulo != null){
                        tarefa.setTitulo(novoTitulo);
                    }
                    if (novaDescricao != null) {
                        tarefa.setDescricao(novaDescricao);
                    }
                    tarefa.setCompleta(novaCompleta);
                    break; 
                }
            }
    }

    public void removerTarefa(int id){
        tarefas.removeIf(tarefa -> tarefa.getId() == id);
    }
}
