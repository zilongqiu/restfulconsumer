package com.example.restfulconsumer;

import com.example.restfulconsumer.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestfulConsumerApplication {

    private static final Logger logger = LoggerFactory.getLogger(RestfulConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestfulConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject("https://demon.free.beeceptor.com/", Quote.class);
            logger.info(quote.toString());
        };
    }
}
