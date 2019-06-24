package com.eliasnogueira.restricao.service.impl;

import com.eliasnogueira.restricao.entity.Restricao;
import com.eliasnogueira.restricao.repository.RestricaoRepository;
import com.eliasnogueira.restricao.service.RestricaoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("restricaoService")
public class RestricaoServiceImpl implements RestricaoService {

    private final RestricaoRepository repository;

    public RestricaoServiceImpl(RestricaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restricao save(Restricao restricao) {
        return null;
    }

    public Optional<Restricao> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
