package application.quarto;

import entities.quarto.Quarto;
import infrastucture.QuartoRepository;

import java.util.List;

public class ListarQuartos {
    private final QuartoRepository repository;

    public ListarQuartos(QuartoRepository quartoRepository) {
        this.repository = quartoRepository;
    }

    public List<Quarto> executar() {
        return repository.listarTodos();
    }
}
