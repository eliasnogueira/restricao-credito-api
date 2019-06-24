package com.eliasnogueira.restricao.exception.advice;

import com.eliasnogueira.restricao.dto.v1.MessageDTO;
import com.eliasnogueira.restricao.exception.v1.RestricaoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestricaoAdvice {

    @ResponseBody
    @ExceptionHandler(RestricaoException.class)
    @ResponseStatus(HttpStatus.OK)
    MessageDTO restricaoHandlerV1(RestricaoException e) {
        return new MessageDTO(e.getMensagem());
    }

    @ResponseBody
    @ExceptionHandler(com.eliasnogueira.restricao.exception.v2.RestricaoException.class)
    @ResponseStatus(HttpStatus.OK)
    com.eliasnogueira.restricao.dto.v2.MessageDTO restricaoHandlerV1(com.eliasnogueira.restricao.exception.v2.RestricaoException e) {
        return new com.eliasnogueira.restricao.dto.v2.MessageDTO(e.getMensagem(), e.getDetalhe());
    }
}
