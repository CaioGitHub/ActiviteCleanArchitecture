import application.tarefa.ConcluirTarefa;
import application.tarefa.CriarTarefa;
import entities.tarefa.Tarefa;
import infrastucture.TarefaRepository;
import infrastucture.TarefaRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciamentoTarefasTest {
    @Test
    void deveCriarTarefa() {
        TarefaRepository repository = new TarefaRepositoryImpl();
        CriarTarefa criarTarefa = new CriarTarefa(repository);

        criarTarefa.executar("Estudar para a prova");

        List<Tarefa> tarefas = repository.listarTodos();
        assertEquals(1, tarefas.size());
        assertFalse(tarefas.get(0).isConcluida());
    }

    @Test
    void deveConcluirTarefa() {
        TarefaRepository repository = new TarefaRepositoryImpl();
        CriarTarefa criarTarefa = new CriarTarefa(repository);
        ConcluirTarefa concluirTarefa = new ConcluirTarefa(repository);

        criarTarefa.executar("Fazer exercícios");
        concluirTarefa.executar("Fazer exercícios");

        Tarefa t = repository.buscarPorDescricao("Fazer exercícios");
        assertTrue(t.isConcluida());
    }
}
