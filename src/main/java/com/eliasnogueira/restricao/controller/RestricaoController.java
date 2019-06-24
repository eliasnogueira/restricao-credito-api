package com.eliasnogueira.restricao.controller;


import com.eliasnogueira.restricao.dto.v1.MessageDTO;
import com.eliasnogueira.restricao.entity.Restricao;
import com.eliasnogueira.restricao.exception.v1.RestricaoException;
import com.eliasnogueira.restricao.service.RestricaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Optional;


@RestController
@Api(value = "Restrição", tags = "Restrições")
public class RestricaoController {

    private final RestricaoService restricaoService;

    public RestricaoController(RestricaoService restricaoService) {
        this.restricaoService = restricaoService;
    }

    @ApiOperation(value = "Consulta se um CPF possui ou não restrição")
    @ApiResponses({
        @ApiResponse(code = 204, message = "Não possui restrição", response = Void.class),
        @ApiResponse(code = 200, message = "Pessoa com restrição", response = MessageDTO.class)
    })
    @GetMapping("/api/v1/restricoes/{cpf}")
    ResponseEntity<Void> one(@PathVariable String cpf) {

        Optional<Restricao> restricaoOptional = restricaoService.findByCpf(cpf);

        if (restricaoOptional.isPresent()) {
            throw new RestricaoException(MessageFormat.format("O CPF {0} possui restrição", cpf));
        }

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Consulta se um CPF possui ou não restrição")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Não possui restrição"),
            @ApiResponse(code = 200, message = "Pessoa com restrição", response = com.eliasnogueira.restricao.dto.v2.MessageDTO.class)
    })
    @GetMapping("/api/v2/restricoes/{cpf}")
    ResponseEntity<Void> oneV2(@PathVariable String cpf) {

        Optional<Restricao> restricaoOptional = restricaoService.findByCpf(cpf);

        if (restricaoOptional.isPresent()) {
            throw new com.eliasnogueira.restricao.exception.v2.RestricaoException(
                    MessageFormat.format("O CPF {0} possui restrição", cpf),
                    restricaoOptional.get().getTipoRestricao());
        }

        return ResponseEntity.noContent().build();
    }
}
