package Exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public String getMessage() {
        return "Usuario não encontrado";
    }
}