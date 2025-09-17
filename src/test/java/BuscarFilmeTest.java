import application.filme.BuscarFilmePorTitulo;
import entities.filme.Filme;
import infrastucture.FilmeRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuscarFilmeTest {
    @Test
    void deveEncontrarFilmePorTitulo() {
        FilmeRepository repository = new FilmeRepository();
        repository.salvar(new Filme("Matrix", "Ficção", 1999));

        BuscarFilmePorTitulo buscar = new BuscarFilmePorTitulo(repository);
        Filme filme = buscar.executar("Matrix");
        assertNotNull(filme);
        assertEquals("Matrix", filme.getTitulo());
    }
}
