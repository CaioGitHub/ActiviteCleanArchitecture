package entities.quarto;

public class Quarto {
    private int numero;
    private String tipo;
    private boolean disponivel;

    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar() {
        if(!disponivel) {
            throw new RuntimeException("Quarto já está reservado.");
        }
        this.disponivel = false;
    }

    public String toString() {
        return "Quarto " + numero + " (" + tipo + ") - " + (disponivel ? "Disponível" : "Reservado");
    }
}
