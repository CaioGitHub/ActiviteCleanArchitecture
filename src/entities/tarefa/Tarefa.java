package entities.tarefa;

public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        if (concluida) {
            throw new RuntimeException("Tarefa já está concluída.");
        }
        this.concluida = true;
    }

    @Override
    public String toString() {
        return descricao + " - " + (concluida ? "Concluída" : "Pendente");
    }
}
