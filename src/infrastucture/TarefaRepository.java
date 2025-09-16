package infrastucture;

import entities.tarefa.Tarefa;

import java.util.List;

public interface TarefaRepository {
    void salvar(Tarefa tarefa);
    List<Tarefa> listarTodos();
    Tarefa buscarPorDescricao(String descricao);
}
