package infrastucture;

import entities.funcionario.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios);
    }
}
