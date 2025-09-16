package exceptions;

public class FilmeNaoEncontradoException extends RuntimeException {
    public FilmeNaoEncontradoException(String titulo) {
        super("Filme não encontrado: " + titulo);
    }
}
