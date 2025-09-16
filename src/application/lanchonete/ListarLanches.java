package application.lanchonete;

import entities.lanchonete.Lanche;
import infrastucture.LancheRepository;

import java.util.List;

public class ListarLanches {
    private final LancheRepository repository;

    public ListarLanches(LancheRepository lancheRepository) {
        this.repository = lancheRepository;
    }

    public List<Lanche> executar() {
        return repository.listar();
    }
}
