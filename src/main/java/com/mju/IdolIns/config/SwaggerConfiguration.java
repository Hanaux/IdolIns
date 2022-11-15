package com.mju.IdolIns.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.aspectj.apache.bcel.classfile.Module;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("idol-debut")
                .pathsToMatch("/idol/**")
                .build();
    }
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("IdolDebut Ins API")
                        .description("IdolDebut Group Insurance ERP Project")
                        .version("v0.0.1"));
    }

}
