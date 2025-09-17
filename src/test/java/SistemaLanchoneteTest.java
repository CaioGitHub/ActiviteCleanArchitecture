import application.lanchonete.CadastrarLanche;
import application.lanchonete.CriarPedidos;
import entities.lanchonete.Lanche;
import entities.lanchonete.Pedido;
import infrastucture.LancheRepository;
import infrastucture.PedidoRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaLanchoneteTest {
    @Test
    void deveCriarPedidoValido() {
        LancheRepository repository = new LancheRepository();
        PedidoRepository pedidoRepository = new PedidoRepository();

        CadastrarLanche cadastrarLanche = new CadastrarLanche(repository);
        cadastrarLanche.executar("X-Burger", 15.0, true);
        cadastrarLanche.executar("X-Salada", 18.0, true);

        List<Lanche> lanches = repository.listar();
        CriarPedidos criarPedidos = new CriarPedidos(pedidoRepository);

        Pedido pedido = criarPedidos.executar(Arrays.asList(lanches.get(0), lanches.get(1)));

        assertEquals(33.0, pedido.getValorTotal(), 0.001);
        assertFalse(pedido.isFinalizado());
    }

    @Test
    void naoDeveAdicionarLancheIndisponivelAoPedido() {
        LancheRepository repository = new LancheRepository();
        PedidoRepository pedidoRepository = new PedidoRepository();

        CadastrarLanche cadastrarLanche = new CadastrarLanche(repository);
        cadastrarLanche.executar("X-Salada", 18.0, false);

        Lanche inv = repository.listar().get(0);
        CriarPedidos criarPedidos = new CriarPedidos(pedidoRepository);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            criarPedidos.executar(Arrays.asList(inv));
        });

        String expectedMessage = "Lanche indisponível: X-Salada";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
