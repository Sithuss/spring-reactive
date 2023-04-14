package com.example.mongodbreactive.controller;

import com.example.mongodbreactive.model.CustomerModel;
import com.example.mongodbreactive.service.CustomerService;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Duration;


//@RestController
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/customers")
    Publisher<CustomerModel> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping(value = "/customer/{id}")
    Publisher<ResponseEntity<CustomerModel>> findCustomerById(@PathVariable(name = "id") String id) {
        return customerService.findCustomerId(id)
                .map(customer -> ResponseEntity.ok(customer))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    Publisher<ResponseEntity<CustomerModel>> postCustomer(@RequestBody CustomerModel customer) {
        return customerService.createCustomer(customer).map(c -> ResponseEntity.ok(c));
    }



}
