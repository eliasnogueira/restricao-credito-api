package com.eliasnogueira.restricao.dto.v2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Restrição v2")
public class RestricaoDTO {

    @ApiModelProperty(required = true, example = "99999999999")
    private String cpf;

    @ApiModelProperty(position = 1, required = true, example = "Bloqueio Judicial")
    private String tipoRestricao;

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
