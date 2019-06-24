package com.eliasnogueira.restricao.dto.v1;

import io.swagger.annotations.ApiModel;

import java.util.Map;

@ApiModel(value = "Validação")
public class ValidacaoDTO {

    private Map<String, String> erros;

    public ValidacaoDTO(Map<String, String> erros) {
        this.erros = erros;
    }

    public Map<String, String> getErros() {
        return erros;
    }
}
