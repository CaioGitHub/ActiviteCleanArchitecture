package infrastucture;

import entities.quarto.Quarto;

import java.util.List;

public interface QuartoRepository {
    void salvar(Quarto quarto);
    Quarto buscarPorNumero(int numero);
    List<Quarto> listarTodos();
}
