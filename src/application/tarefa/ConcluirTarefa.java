package application.tarefa;

import infrastucture.TarefaRepository;

public class ConcluirTarefa {
    private final TarefaRepository repository;

    public ConcluirTarefa(TarefaRepository tarefaRepository) {
        this.repository = tarefaRepository;
    }

    public void executar(String descricao) {
        var tarefa = repository.buscarPorDescricao(descricao);
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não encontrada: " + descricao);
        }
        tarefa.concluir();
    }

}
