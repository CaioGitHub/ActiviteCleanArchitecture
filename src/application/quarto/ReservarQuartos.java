package application.quarto;

import infrastucture.QuartoRepository;

public class ReservarQuartos {
    private final QuartoRepository repository;

    public ReservarQuartos(QuartoRepository quartoRepository) {
        this.repository = quartoRepository;
    }

    public void executar(int numero) {
        var quarto = repository.buscarPorNumero(numero);
        if (quarto == null) {
            throw new IllegalArgumentException("Quarto não encontrado: " + numero);
        }
        quarto.reservar();
    }
}
