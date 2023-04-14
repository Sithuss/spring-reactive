package com.example.mongodbreactive.config;

import com.example.mongodbreactive.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> router(CustomerHandler handler) {
        return RouterFunctions.route()
                .GET("/customers", handler::getAllCustomers)
                .POST("/customers", handler::postCustomers)
                .build();
    }
}
