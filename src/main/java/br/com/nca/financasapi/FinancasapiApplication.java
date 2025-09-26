package br.com.nca.financasapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class FinancasapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancasapiApplication.class, args);
    }

}
