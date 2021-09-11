package com.api.controlfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.api.controlfood.controller"))
                .paths(PathSelectors.any()).build().useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("ControlFood")
                .description(
                        "Gerenciador de estabelecimentos no setor alimentício. Tem como objetivo auxiliar o empreendedor" +
                                " a entrar e permanecer neste mundo de deliveries, proporcionando dados do produto que " +
                                "permitem tomadas de decisão assertivas de forma rápida e inteligente.\n"
                                + "Saiba mais através de nosso [GitHub](https://github.com/EliasBorges/controlfood-api)."
                ).version("1.0.0")
                .build();
    }
}
