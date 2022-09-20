/**
 *Class annotated as SpringBootApplication with main() method
 *to start Spring-boot application
 * @author Ryhor Pishchyk
 * */

package com.epam.controller.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.epam.controller", "com.epam.service", "com.epam.repository"})
@EnableJpaRepositories(basePackages={"com.epam.controller", "com.epam.service", "com.epam.repository"})
@EntityScan(basePackages={"com.epam.repository.model"})
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}