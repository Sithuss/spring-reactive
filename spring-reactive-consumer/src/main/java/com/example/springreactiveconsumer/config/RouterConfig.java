package com.example.springreactiveconsumer.config;

import com.example.springreactiveconsumer.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> router(CustomerHandler handler) {
        return RouterFunctions.route().GET("/all", handler::getAll).build();
    }
}
