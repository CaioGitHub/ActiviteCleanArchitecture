package infrastucture;

import entities.aluno.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos);
    }
}
