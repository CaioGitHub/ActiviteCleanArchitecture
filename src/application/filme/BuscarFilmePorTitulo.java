package application.filme;

import entities.filme.Filme;
import infrastucture.FilmeRepository;

public class BuscarFilmePorTitulo {
    private final FilmeRepository repository;

    public BuscarFilmePorTitulo(FilmeRepository repository) {
        this.repository = repository;
    }

    public Filme executar(String titulo) {
        return repository.buscarPorTitulo(titulo);
    }
}
