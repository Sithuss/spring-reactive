package com.example.mongodbreactive.repository;

import com.example.mongodbreactive.model.CustomerModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerRepository extends ReactiveMongoRepository<CustomerModel, String> {
}
