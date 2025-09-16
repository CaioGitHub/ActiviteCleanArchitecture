package infrastucture;

import entities.lanchonete.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<>();

    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listar() {
        return new ArrayList<>(pedidos);
    }
}
