package application.lanchonete;

import entities.lanchonete.Pedido;

public class FinalizarPedidos {
    public void executar(Pedido peiddo) {
        peiddo.finalizar();
    }
}
