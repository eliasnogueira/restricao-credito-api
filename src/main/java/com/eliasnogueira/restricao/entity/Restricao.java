package com.eliasnogueira.restricao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Restricao {

    @Id
    @GeneratedValue
    private Long id;

    private String cpf;

    private String tipoRestricao;

    public Restricao() {}

    public Restricao(String cpf, String tipoRestricao) {
        this.cpf = cpf;
        this.tipoRestricao = tipoRestricao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoRestricao() {
        return tipoRestricao;
    }

    public void setTipoRestricao(String tipoRestricao) {
        this.tipoRestricao = tipoRestricao;
    }
}
