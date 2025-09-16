package infrastucture;

import entities.lanchonete.Lanche;

import java.util.ArrayList;
import java.util.List;

public class LancheRepository {
    private List<Lanche> lanches = new ArrayList<>();

    public void salvar(Lanche lanche) {
        lanches.add(lanche);
    }

    public List<Lanche> listar() {
        return new ArrayList<>(lanches);
    }
}
