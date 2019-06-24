package com.eliasnogueira.restricao.swagger;

import com.google.common.util.concurrent.ListenableFuture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                tags(new Tag("Restrições", "Consulta uma restrição")).
                genericModelSubstitutes(ListenableFuture.class).
                useDefaultResponseMessages(false).
                apiInfo(apiInfo()).
                select().
                apis(RequestHandlerSelectors.basePackage("com.eliasnogueira.restricao.controller")).
                paths(PathSelectors.any()).
                build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().
                title("Consulta Restrição de Crédito").
                description("Aplicação para consultar a restrição de um CPF").
                build();
    }
}
