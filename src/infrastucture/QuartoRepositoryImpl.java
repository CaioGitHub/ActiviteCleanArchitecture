package infrastucture;

import entities.quarto.Quarto;
import java.util.ArrayList;
import java.util.List;

public class QuartoRepositoryImpl implements QuartoRepository {
    private final List<Quarto> quartos = new ArrayList<>();

    @Override
    public void salvar(Quarto quarto) {
        quartos.add(quarto);
    }

    @Override
    public Quarto buscarPorNumero(int numero) {
        return quartos.stream()
                .filter(q -> q.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Quarto> listarTodos() {
        return new ArrayList<>(quartos);
    }
}
