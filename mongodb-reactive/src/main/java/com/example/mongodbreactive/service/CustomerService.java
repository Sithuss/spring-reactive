package com.example.mongodbreactive.service;

import com.example.mongodbreactive.model.CustomerModel;
import com.example.mongodbreactive.repository.CustomerRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Collections;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Flux<CustomerModel> findAllCustomers() {
        return customerRepository.findAll()
                .delayElements(Duration.ofSeconds(3));
    }

    public Mono<CustomerModel> createCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    public Mono<CustomerModel> findCustomerId(String customerId) {
        return customerRepository.findById(customerId)
                .delayElement(Duration.ofSeconds(3));
    }
}
