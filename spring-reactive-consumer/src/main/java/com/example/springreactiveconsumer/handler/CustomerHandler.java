package com.example.springreactiveconsumer.handler;

import com.example.springreactiveconsumer.model.CustomerModel;
import com.example.springreactiveconsumer.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CustomerHandler {
    private final CustomerService customerService;

    public CustomerHandler(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Only Mono<ServerResponse> param -> ServerRequset
    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerService.getAll(), CustomerModel.class);
    }
}
