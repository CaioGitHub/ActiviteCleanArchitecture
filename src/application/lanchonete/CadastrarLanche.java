package application.lanchonete;

import entities.lanchonete.Lanche;
import infrastucture.LancheRepository;

public class CadastrarLanche {
    private final LancheRepository repository;

    public CadastrarLanche(LancheRepository lancheRepository) {
        this.repository = lancheRepository;
    }

    public void executar(String nome, double preco, boolean disponivel) {
        var lanche = new Lanche(nome, preco, disponivel);
        repository.salvar(lanche);
    }
}
