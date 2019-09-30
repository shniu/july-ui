package com.github.shniu.spring.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shniu
 * @date 2019/09/24 19:39:59
 */
@Configuration
@EnableSwagger2
@Profile(value = {"dev", "local", "ci"})
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.github.shniu"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("TinyURL Service API Document")
            .description("The api document for tinyurl service.")
            .version("0.0.1")
            .license("MIT")
            .contact(new Contact("shniu", null, "niushaohan@digcredit.com"))
            // .termsOfServiceUrl("https://fsp.digcredit.com/")
            .build();
    }
}
