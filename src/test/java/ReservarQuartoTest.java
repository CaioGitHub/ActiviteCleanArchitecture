import application.quarto.CadastrarQuarto;
import application.quarto.ListarQuartos;
import application.quarto.ReservarQuartos;
import entities.quarto.Quarto;
import infrastucture.QuartoRepository;
import infrastucture.QuartoRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ReservarQuartoTest {
    @Test
    void deveReservarQuarto() {
        QuartoRepository repository = new QuartoRepositoryImpl();
        CadastrarQuarto cadastrar = new CadastrarQuarto(repository);
        ListarQuartos listar = new ListarQuartos(repository);
        ReservarQuartos reservar = new ReservarQuartos(repository);

        cadastrar.executar(new Quarto(101, "Solteiro"));
        List<Quarto> quartos = listar.executar();
        assertEquals(1, quartos.size());

        reservar.executar(101);

        Quarto q = repository.buscarPorNumero(101);
        assertFalse(q.isDisponivel());
    }
}
