package com.eliasnogueira.restricao;

import com.eliasnogueira.restricao.entity.Restricao;
import com.eliasnogueira.restricao.entity.TipoRestricao;
import com.eliasnogueira.restricao.repository.RestricaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabaseRestricao(RestricaoRepository restricaoRepository) {
        return args -> {
            restricaoRepository.save(new Restricao("97093236014", TipoRestricao.BLOQUEIO_JURICIAL.value()));
            restricaoRepository.save(new Restricao("60094146012", TipoRestricao.CARTAO_CREDITO.value()));
            restricaoRepository.save(new Restricao("84809766080", TipoRestricao.BANCARIA.value()));
            restricaoRepository.save(new Restricao("62648716050", TipoRestricao.SPC.value()));
            restricaoRepository.save(new Restricao("26276298085", TipoRestricao.SPC.value()));
            restricaoRepository.save(new Restricao("01317496094", TipoRestricao.CARTAO_CREDITO.value()));
            restricaoRepository.save(new Restricao("55856777050", TipoRestricao.BANCARIA.value()));
            restricaoRepository.save(new Restricao("19626829001", TipoRestricao.BLOQUEIO_JURICIAL.value()));
            restricaoRepository.save(new Restricao("24094592008", TipoRestricao.BANCARIA.value()));
            restricaoRepository.save(new Restricao("58063164083", TipoRestricao.BANCARIA.value()));
        };
    }

}