package infrastucture;

import entities.filme.Filme;
import exceptions.FilmeNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class FilmeRepository {
    private final List<Filme> filmes = new ArrayList<>();

    public void salvar(Filme filme) {
        filmes.add(filme);
    }

    public Filme buscarPorTitulo(String titulo) {
        return filmes.stream()
                .filter(f -> f.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new FilmeNaoEncontradoException(titulo));
    }
}
