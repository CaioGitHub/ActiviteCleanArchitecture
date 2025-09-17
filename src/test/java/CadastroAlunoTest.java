import application.aluno.CadastrarAluno;
import entities.aluno.Aluno;
import infrastucture.AlunoRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroAlunoTest {

    @Test
    public void testCadastrarAluno() {
        AlunoRepository repository = new AlunoRepository();
        CadastrarAluno cadastrarAluno = new CadastrarAluno(repository);

        cadastrarAluno.executar("João Silva", "2023001", "Engenharia");

        List<Aluno> alunos = repository.listarTodos();
        assertEquals(1, alunos.size());
        Aluno a = alunos.get(0);
        assertEquals("João Silva", a.getNome());
        assertEquals("2023001", a.getMatricula());
        assertEquals("Engenharia", a.getCurso());
    }

}
