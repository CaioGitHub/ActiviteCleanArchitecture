package application.aluno;

import entities.aluno.Aluno;
import infrastucture.AlunoRepository;

public class CadastrarAluno {
    private final AlunoRepository repository;

    public CadastrarAluno(AlunoRepository repository) {
        this.repository = repository;
    }

    public void executar(String nome, String matricula, String curso) {
        var aluno = new Aluno(nome, matricula, curso);
        repository.salvar(aluno);
    }
}
