package application.tarefa;

import entities.tarefa.Tarefa;
import infrastucture.TarefaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ListarTarefasPendentes {
    private final TarefaRepository repository;

    public ListarTarefasPendentes(TarefaRepository tarefaRepository) {
        this.repository = tarefaRepository;
    }

    public List<Tarefa> executar() {
        return repository.listarTodos().stream()
                .filter(tarefa -> !tarefa.isConcluida())
                .collect(Collectors.toList());
    }
}
