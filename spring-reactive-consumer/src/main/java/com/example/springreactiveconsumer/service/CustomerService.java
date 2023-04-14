package com.example.springreactiveconsumer.service;

import com.example.springreactiveconsumer.model.CustomerModel;
import com.example.springreactiveconsumer.proxy.CustomerProxy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

    private final CustomerProxy customerProxy;

    public CustomerService(CustomerProxy customerProxy) {
        this.customerProxy = customerProxy;
    }

    public Flux<CustomerModel> getAll() {
        return customerProxy.getAll();
    }
}
