package br.com.lucas.pixjp_backend.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
