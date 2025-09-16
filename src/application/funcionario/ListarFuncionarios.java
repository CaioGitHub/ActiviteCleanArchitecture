package application.funcionario;

import entities.funcionario.dto.FuncionarioDTO;
import infrastucture.FuncionarioRepository;

import java.util.List;

public class ListarFuncionarios {
    private final FuncionarioRepository repository;

    public ListarFuncionarios(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<FuncionarioDTO> executar() {
        return repository.listarTodos().stream()
                .map(f -> new FuncionarioDTO(f.getNome(), f.getCargo(), f.getSalario()))
                .toList();
    }
}
