package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableOpenApi
public class SwaggerConfiguration {

    //Xây dựng các đối tượng API và thông tin của API//Build API object to show on SWAGGER DASHBOARD
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    //Xây dựng lọc đường dẫn cho các api// Api path filter
    private Predicate<String> postPaths() {
        return regex("/.*");
    }

    //Xây dựng thông tin cho api// API INFORMATION IMPLEMENT
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(" API")
                .description(" API reference for developers")
                .termsOfServiceUrl("google.com")
                .contact(new Contact("dhdhd", "not url", "shiki")).license("1.0")
                .licenseUrl("google.com").version("1.0").build();
    }
}