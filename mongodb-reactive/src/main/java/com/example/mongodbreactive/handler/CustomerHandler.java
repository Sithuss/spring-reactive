package com.example.mongodbreactive.handler;

import com.example.mongodbreactive.model.CustomerModel;
import com.example.mongodbreactive.service.CustomerService;
import com.example.mongodbreactive.validation.CustomerValidator;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class CustomerHandler {

    private final CustomerService customerService;

    public CustomerHandler(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Mono<ServerResponse> getAllCustomers(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerService.findAllCustomers().delayElements(Duration.ofSeconds(3)), CustomerModel.class);
    }

    public Mono<ServerResponse> postCustomers(ServerRequest request) {
        CustomerValidator validator = new CustomerValidator();
        return request.bodyToMono(CustomerModel.class)
                .flatMap(validator::validate)
                .flatMap(customerService::createCustomer)
                .flatMap(cust -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cust));
//                .onErrorMap(e -> new RuntimeException("Creation error!"));
    }
}
