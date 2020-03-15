package com.anz.codingchallenge.accountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

@SpringBootApplication
public class AccountApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AccountApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
    
    /**
     * Sets up Jackson to handle JSR310 dates properly.
     *
     * @param objectMapper the Jackson object mapper used by the application.
     */
    @Autowired
    public void configureJackson(@Autowired ObjectMapper objectMapper) {
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new GuavaModule());
    }
}
