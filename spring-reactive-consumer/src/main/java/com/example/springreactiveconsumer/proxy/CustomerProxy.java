package com.example.springreactiveconsumer.proxy;

import com.example.springreactiveconsumer.exception.CustomerRetrievedException;
import com.example.springreactiveconsumer.model.CustomerModel;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Flux;

@Component
public class CustomerProxy {

    private final WebClient webClient;

    public CustomerProxy(WebClient webClient) {
        this.webClient = webClient;
    }
    /*
    error handling -> ommit
     */
    public Flux<CustomerModel> getAll() {
        var defCustomer = new CustomerModel("defaultId", "defaultName", "default", "default", null);
        return webClient.get()
                .uri("/customers")
                .exchangeToFlux(res -> res.bodyToFlux(CustomerModel.class))
                //.onErrorReturn(defCustomer);
//                .onErrorReturn(e -> e instanceof WebClientRequestException, defCustomer);
                //.onErrorReturn(WebClientRequestException.class, defCustomer);
                //.onErrorResume(e -> Flux.just(defCustomer));
//                .onErrorResume(e -> e instanceof WebClientRequestException,
//                        e -> Flux.just(defCustomer));
//                .onErrorResume(WebClientRequestException.class, e -> Flux.just(defCustomer));
                .onErrorMap(e -> new CustomerRetrievedException());
    }
}
