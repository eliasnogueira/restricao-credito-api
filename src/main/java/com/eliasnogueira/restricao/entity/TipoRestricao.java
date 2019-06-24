package com.eliasnogueira.restricao.entity;

public enum TipoRestricao {

    BLOQUEIO_JURICIAL("Bloqueio Judicial"),
    CARTAO_CREDITO("Cartão de Crédito"),
    SPC("SPC"),
    BANCARIA("Bancária");

    private String value;

    TipoRestricao(String value) {
        this.value  =value;
    }

    public String value() {
        return value;
    }
}
