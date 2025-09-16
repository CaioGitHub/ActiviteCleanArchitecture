package application.tarefa;

import entities.tarefa.Tarefa;
import infrastucture.TarefaRepository;

public class CriarTarefa {
    private final TarefaRepository repository;

    public CriarTarefa(TarefaRepository tarefaRepository) {
        this.repository = tarefaRepository;
    }

    public void executar(String descricao) {
        var tarefa = new Tarefa(descricao);
        repository.salvar(tarefa);
    }
}
