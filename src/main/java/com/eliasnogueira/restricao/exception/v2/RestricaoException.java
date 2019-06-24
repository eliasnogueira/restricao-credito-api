package com.eliasnogueira.restricao.exception.v2;

public class RestricaoException extends RuntimeException {

    private final String mensagem;
    private final String detalhe;

    public RestricaoException(String mensagem, String detalhe) {
        this.mensagem = mensagem;
        this.detalhe = detalhe;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDetalhe() {
        return detalhe;
    }

    @Override
    public String toString() {
        return mensagem + " " + detalhe;
    }
}
