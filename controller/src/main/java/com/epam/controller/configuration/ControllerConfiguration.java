/**
 * Configuration class for Spring-boot
 * @author Ryhor Pishchyk*
 * */

package com.epam.controller.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan({"com.epam.controller", "com.epam.service"})
public class ControllerConfiguration {

    /**
    * Swagger configuration for documentation REST API
    * @return Docket object
    * */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis (RequestHandlerSelectors.basePackage ("com.epam.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
    * Main information about swagger API
    * */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title ("Spring Boot with Swagger2 to create RESTful API")
                .contact(new Contact("Ryhor Pishchyk", "http://epam.com", "ryhor_pishchyk@epam.com"))
                .description ("Restful")
                .termsOfServiceUrl("http://epam.com")
                .version("1.0")
                .build();
    }
}