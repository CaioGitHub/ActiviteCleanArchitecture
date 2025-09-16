package application.quarto;

import entities.quarto.Quarto;
import infrastucture.QuartoRepository;

public class CadastrarQuarto {
    private final QuartoRepository repository;

    public CadastrarQuarto(QuartoRepository quartoRepository) {
        this.repository = quartoRepository;
    }

    public void executar(Quarto quarto) {
        repository.salvar(quarto);
    }
}
