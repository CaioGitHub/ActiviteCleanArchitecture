package infrastucture;

import entities.tarefa.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaRepositoryImpl implements TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public void salvar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public List<Tarefa> listarTodos() {
        return new ArrayList<>(tarefas);
    }

    @Override
    public Tarefa buscarPorDescricao(String descricao) {
        return tarefas.stream()
                .filter(t -> t.getDescricao().equals(descricao))
                .findFirst()
                .orElse(null);
    }
}
