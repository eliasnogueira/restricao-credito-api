/*
 * MIT License
 *
 * Copyright (c) 2020 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.eliasnogueira.restricao.controller;

import com.eliasnogueira.restricao.dto.v1.MessageDTO;
import com.eliasnogueira.restricao.entity.Restricao;
import com.eliasnogueira.restricao.exception.v1.RestricaoException;
import com.eliasnogueira.restricao.service.RestricaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.text.MessageFormat;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Restrição", tags = "Restrições")
public class RestricaoController {

    private final RestricaoService restricaoService;
    private static final String CPF_POSSUI_RESTRICAO = "CPF {0} possui restrição";

    public RestricaoController(RestricaoService restricaoService) {
        this.restricaoService = restricaoService;
    }

    @ApiOperation(value = "Consulta se um CPF possui ou não restrição")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Não possui restrição"),
        @ApiResponse(code = 200, message = "Pessoa com restrição", response = MessageDTO.class)
    })
    @GetMapping("/api/v1/restricoes/{cpf}")
    public ResponseEntity<Void> one(@PathVariable String cpf) {
        Optional<Restricao> restricaoOptional = restricaoService.findByCpf(cpf);

        if (restricaoOptional.isPresent()) {
            throw new RestricaoException(MessageFormat.format(CPF_POSSUI_RESTRICAO, cpf));
        }

        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Consulta se um CPF possui ou não restrição")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Não possui restrição"),
        @ApiResponse(code = 200, message = "Pessoa com restrição", response = com.eliasnogueira.restricao.dto.v2.MessageDTO.class)
    })
    @GetMapping("/api/v2/restricoes/{cpf}")
    public ResponseEntity<Void> oneV2(@PathVariable String cpf) {
        Optional<Restricao> restricaoOptional = restricaoService.findByCpf(cpf);

        if (restricaoOptional.isPresent()) {
            throw new com.eliasnogueira.restricao.exception.v2.RestricaoException(
                MessageFormat.format(CPF_POSSUI_RESTRICAO, cpf),
                restricaoOptional.get().getTipoRestricao());
        }

        return ResponseEntity.notFound().build();
    }
}
