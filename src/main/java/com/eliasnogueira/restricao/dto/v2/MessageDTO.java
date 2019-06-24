package com.eliasnogueira.restricao.dto.v2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Mensagem v2")
public class MessageDTO {

    @ApiModelProperty(position = 0, required = true, example = "O CPF 999999999 não foi encontrado")
    private String retorno;

    @ApiModelProperty(position = 1, required = true, example = "Bloqueio Judicial")
    private String detalhe;

    public MessageDTO(String retorno) {
        this.retorno = retorno;
    }

    public MessageDTO(String retorno, String detalhe) {
        this.retorno = retorno;
        this.detalhe = detalhe;
    }

    public MessageDTO(){}

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }
}
