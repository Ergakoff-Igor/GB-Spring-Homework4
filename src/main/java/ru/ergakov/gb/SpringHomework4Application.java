package ru.ergakov.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringHomework4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringHomework4Application.class, args);
    }

}
