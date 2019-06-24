package com.eliasnogueira.restricao.service;

import com.eliasnogueira.restricao.entity.Restricao;

import java.util.Optional;

public interface RestricaoService {

    Restricao save(Restricao restricao);
    Optional<Restricao> findByCpf(String cpf);

}
