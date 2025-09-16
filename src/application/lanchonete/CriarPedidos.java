package application.lanchonete;

import entities.lanchonete.Lanche;
import entities.lanchonete.Pedido;
import infrastucture.PedidoRepository;

import java.util.List;

public class CriarPedidos {
    private final PedidoRepository repository;

    public CriarPedidos(PedidoRepository pedidoRepository) {
        this.repository = pedidoRepository;
    }

    public Pedido executar(List<Lanche> lanches) {
        Pedido pedido = new Pedido();
        for (Lanche lanche : lanches) {
            pedido.adicionarLanche(lanche);
        }
        repository.salvar(pedido);
        return pedido;
    }
}
