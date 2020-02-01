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